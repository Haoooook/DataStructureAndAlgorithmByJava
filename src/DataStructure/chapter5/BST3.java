package DataStructure.chapter5;

/**
 * 二分搜索树Binary Search Tree
 * <p>
 * 每个节点大于左子节点，小于右子节点；
 * 存储的数据必须有可比较性；(即 对泛型E添加限制条件 实现Comparable接口)
 * <p>
 * <p>
 * 改进：在add（）里优化臃肿的递归条件,使递归到为空的叶子节点终止
 * <p>
 * 增加:
 * contains（） 判断是否包含数据e 递归实现
 * 终止条件，找到节点==null，返false（既是判断在一开始判断根节点是否为空，也是在判断到叶子节点时都没找到即没有包含改元素）
 * <p>
 * 前序遍历
 *
 * @author Damon
 * @create 2020-10-25 13:05
 */
public class BST3<E extends Comparable> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST3() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //向根节点为node的树添加数据，递归算法
    private Node add(Node node, E e) {

        //判断根节点为空，那么e存到根节点
        //同理，当递归到叶子节点为空时 也创建新的节点接收数据并返回节点给上一层
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    /**
     * 添加数据e
     *
     * @param e
     */
    public void add(E e) {
        root = add(root, e);
    }

    /**
     * 二叉树是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null)
            return false;

        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else //(e.compareTo(node.e) > 0)
            return contains(node.right, e);
    }

    /**
     * 前序遍历
     * 父节点---左子节点----右子节点
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        //终止条件
        if (node == null)
            return;
        //父节点的元素
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历(附带了一个排序效果)
     * 左子节点---父节点---右子节点
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     * 左子节点---右子节点---父节点
     * 典型的应用：是否内存的时候先处理节点的子节点再处理该节点
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null)
            return;

        preOrder(node.left);
        preOrder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的 描述二叉树的字符串
     *
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("-->");
        return res.toString();
    }

}
