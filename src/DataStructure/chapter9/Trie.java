package DataStructure.chapter9;

import java.util.TreeMap;

/**
 * Trie 字典树 树结构 不直接存储元素而是存储Map对象，Map存储数据
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

    public void recursionAdd(String words) {
        recursionAdd(root, words, 0);
    }

    private void recursionAdd(Node cur, String words, int index) {
        //终止条件
        //辅助长度index 和 words的长度一致 & isWord标识为false
        //此时就是新添加字符串 维护size 如果最后是isWord标识为true不走这个判断 不维护size 直接结束；
        if (!cur.isWord && index == words.length()) {
            cur.isWord = true;
            size++;
            return;
        }

        if (words.length() > index) {//还未遍历完words字符时
            char c = words.charAt(index);
            if (cur.next.get(c) == null) {
                cur = cur.next.put(c, new Node());//此时含有c字符的节点是叶子节点，继续创建下一个节点以保存words后续的字符
            }
            recursionAdd(cur.next.get(c), words, index + 1);//此时含有c字符的节点不是叶子节点，递归。
        }
    }

    /**
     * 查询是否含有字符串
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
}
