package DataStructure.chapter6;

/**
 * @author Damon
 * @create 2020-11-07 14:42
 */
public class BSTMap<K extends Comparable, V> implements Map<K, V> {

    //底层实现BST的节点
    private class Node {

        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 像二分搜索树中添加key-value键值对
     *
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 底层
     * 递归实现二分搜索树左右子树添加key-value键值对
     * 值得注意的是，当含有key时候，添加的value覆盖原有的value
     * 递归结束条件：找到node=null 或 node.key = key
     *
     * @param node
     * @param key
     * @param value
     * @return 返回添加完毕后的新的BST树
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else//含有key时候，添加的value覆盖原有的value
            node.value = value;

        return node;
    }

    /**
     * 判断BST中是否包含key
     */
    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    /**
     * 获得BST存储的 key对应的value值
     *
     * @param key
     * @return
     */
    @Override
    public V get(K key) {
        Node getNode = getNode(root, key);
        return getNode.value;
    }

    /**
     * 底层
     * 递归实现，判断左右子树的节点是否包含key
     * 递归结束条件：找到节点node是空，或 找到node.key=key
     *
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else//key.compareTo(node.key) > 0
            return getNode(node.right, key);
    }

    /**
     * @param key
     * @param newValue
     */
    @Override
    public void set(K key, V newValue) {
        Node getNode = getNode(root, key);

        if (getNode == null)
            throw new IllegalArgumentException(key + " is exist！");

        getNode.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V remove(K key) {
        Node getNode = getNode(root, key);

        if (getNode != null) {
            root = remove(root, key);
            return getNode.value;
        }
        return null;
    }

    /**
     * 寻找二叉树的最小值
     *
     * @param node
     * @return 最小值所在的节点
     */
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    /**
     * 删除最小值所在的节点
     *
     * @param node 为二叉树的根
     * @return 删除最小值所在的节点后新的二叉树的根 node
     */
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除以node为根的二分搜索树中 值为key的节点
     *
     * @param node
     * @param key
     * @return 删除节点后新的树的根
     */
    private Node remove(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {

            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {

            node.right = remove(node.right, key);
            return node;
        } else {//e ==node.e
            //target节点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //target节点右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //待删除节点左右子树均不为空
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }
}
