package DataStructure.chapter9.LeetCode211;

import java.util.TreeMap;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * <p>
 * 实现词典类 WordDictionary ：
 * <p>
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与word 匹配，则返回 true ；否则，返回 false 。
 * word 中可能包含一些 '.' ，每个. 都可以表示任何一个字母。
 * 即 '.' 代表任意字母 有 . 就跳过 算他查询成功
 *
 * @author Haoooook
 * @create 2020-11-25 22:08
 */
class WordDictionary {

    //定义节点
    private class Node {
        private boolean isWord;
        private TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    //初始化 根节点
    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {

        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cur.next.putIfAbsent(c, new Node());
            cur = cur.next.get(c);
        }
        cur.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node cur, String word, int index) {
        //终止条件
        if (index == word.length())
            return cur.isWord;

        char c = word.charAt(index);
        //两种情况
        if (c != '.') {//没有遇到.
            if (cur.next.get(c) == null)
                return false;
            return match(cur.next.get(c), word, index + 1);
        } else {//遇到.
            for (char nextChar : cur.next.keySet())//把当前节点后的所有节点都查看一遍
                if (match(cur.next.get(nextChar), word, index + 1))
                    return true;
            return false;
        }
    }

}
