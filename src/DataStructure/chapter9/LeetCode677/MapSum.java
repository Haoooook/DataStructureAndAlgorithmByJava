package DataStructure.chapter9.LeetCode677;

import java.util.TreeMap;

/**
 * 实现一个 MapSum 类，支持两个方法，insert和sum：
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 * @author Haoooook
 * @create 2020-11-29 15:38
 */
class MapSum {
    //定义节点
    private class Node {
        private int value;
        private TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    //初始化根节点
    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        //从根节点开始向下遍历 没有就创建一个默认value为0的节点 有则把对应的value换成val
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        //对前缀进行遍历 找到最后字符的那个节点
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node cur) {

        //终止条件 在for循环里 其实已经实现终止条件了
//        if (cur.next.size() == 0)
//            return cur.value;

        int res = cur.value;
        //如果当前节点还有子节点，那么继续去遍历找到他们的val 如果没有子节点了跳出循环
        for (char c : cur.next.keySet()) {
            res += sum(cur.next.get(c));
        }
        return res;
    }
}