package DataStructure.chapter9;

import java.util.TreeMap;

/**
 * Trie 字典树、前缀树 树结构 不直接存储元素而是存储Map对象，Map对象存储数据
 * 类似：手机通讯录找人每输入一个字会找到对应的含有这个字的条目
 * 特点：
 * 1.根节点不保存任何数据
 * 2.时间复杂度O(w) w是字符串的长度，
 * 3.每个节点有若干指向下一个节点的指针
 *
 * @author Haoooook
 * @create 2020-11-23 21:35
 */
public class Trie {
    //设置节点
    private class Node {
        public boolean isWord;//标识，当到当前字符为止 已经组成了一个词 初始为false
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 添加一个新字符串到Trie中
     *
     * @param words 要传入的字符串
     */
    public void add(String words) {
        //从根节点起步开始，根节点不保存任何数据！
        Node cur = root;
        for (int i = 0; i < words.length(); i++) {
            //挨个取字符串的单个字符
            char c = words.charAt(i);
            if (cur.next.get(c) == null) {
                //如果从根节点开始，找到了treeMap对象的 key = c 的那个对象
                //  依次看他们的TreeMap对象里的 value = Node 是否为空
                //      为空 代表原来的字典树里包含了c但是 他是叶子节点后面的节点没有了，那么就直接在他的后面new Node（）对象
                cur.next.put(c, new Node());//treeMap里put涵盖了 添加和覆盖操作
            }
            //如果不为空，有下一个节点 那么直接返回下一个节点
            cur = cur.next.get(c);
        }
        //维护size
        //当遍历完words，字符都添加进去了判断此时的isWord是否为真
        //  如果本来就为真，即原字典树里有这个words 即 不用维护size；
        //  否则，就是原字典树里没有 手动把isWords改true
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    //递归实现的添加方法
    public void recursionAdd(String words) {
        //从根节点开始
        recursionAdd(root, words, 0);
    }

    /**
     * 递归实现的添加方法
     *
     * @param cur   当前节点
     * @param words 要添加的单词
     * @param index 当前辅助长度 用来记录是否遍历完words
     */
    private void recursionAdd(Node cur, String words, int index) {
        //终止条件
        //辅助长度index 和 words的长度一致 & isWord标识为false
        //此时表示 添加新的字符串 维护size 如果最后是isWord标识为true不走这个判断 不维护size 直接结束；
        if (index == words.length()) {
            cur.isWord = true;
            size++;
            return;
        }
//方法一：
        if (words.length() > index) {//字符没有遍历完
            char c = words.charAt(index);
            if (cur.next.get(c) == null)//原Trie没有该字符，则增加
                cur.next.put(c, new Node());

            recursionAdd(cur.next.get(c), words, index + 1);//原Trie有该字符，继续向下遍历。
        }
/*方法二：使用public V putIfAbsent(K key, V value)
            如果K没有关联一个value（或K映射为null）那么就关联一个给定的value值 并返null
            如果K关联了value 那么就直接返回value；

        cur.next.putIfAbsent(words.charAt(index), new Node());

        recursionAdd(cur.next.get(words.charAt(index)), words, index + 1);
*/
    }

    /**
     * 查询是否含有字符串
     *
     * @param words 目标字符串
     * @return
     */
    public boolean contains(String words) {
        Node cur = root;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    //递归实现
    public boolean recursionContains(String words) {
        return recursionContains(root, words, 0);
    }

    private boolean recursionContains(Node cur, String words, int index) {
        //终止条件 遍历完words最后一个字符后证明包含这个words
        if (index == words.length())
            return cur.isWord;

        if (cur.next.containsKey(words.charAt(index)))
            recursionContains(cur.next.get(words.charAt(index)), words, index + 1);
        return false;
    }

    //查询Trie中是否有以 words 为前缀的单词
    public boolean isPrefix(String words) {
        Node cur = root;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    //递归实现 查询前缀
    private boolean recursionIsPrefix(String prefix) {
        return recursionIsPrefix(root, prefix, 0);
    }

    private boolean recursionIsPrefix(Node cur, String prefix, int index) {
        if (index == prefix.length())
            return true;

        if (cur.next.containsKey(prefix.charAt(index)))
            recursionIsPrefix(cur.next.get(prefix.charAt(index)), prefix, index + 1);
        return false;
    }
}
