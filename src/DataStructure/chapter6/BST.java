package DataStructure.chapter6;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二分搜索树Binary Search Tree
 * 增加
 * 删除任意位置的节点
 * 中序前驱，中序后继---> 中序遍历 pre target succ
 * pre即target的中序前驱，succ是target的中序后继
 *
 * @author Damon
 * @create 2020-10-25 13:05
 */
public class BST<E extends Comparable> {

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

    public BST() {
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

    /**
     * 层序遍历（广度优先遍历）
     * 逐层向下遍历
     * 非递归方式实现，队列结构
     */
    public void levelOrder() {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
        }

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

    /**
     * 寻找二叉树的最小值
     *
     * @return
     */
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        Node minNode = minimum(root);
        return minNode.e;
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
     * 寻找二叉树的最大值
     *
     * @return
     */
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");
        Node maxNode = maximum(root);
        return maxNode.e;
    }

    /**
     * 寻找二叉树的最大值
     *
     * @param node
     * @return 最小值所在的节点
     */
    private Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    /**
     * 找到最小值所在的节点，删除并返回最小值
     *
     * @return
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
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
     * 找到最小值所在的节点，删除并返回最大值
     *
     * @return
     */
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;

    }

    /**
     * 删除最大值所在的节点
     *
     * @param node 为二叉树的根
     * @return 删除最大值所在的节点后新的二叉树的根 node
     */
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 从二分搜索树中删除元素为e的节点
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除以node为根的二分搜索树中 值为e的节点
     *
     * @param node
     * @param e
     * @return 删除节点后新的树的根
     */
    private Node remove(Node node, E e) {
        if (node == null)
            return null;

        if (e.compareTo(node.e) < 0) {

            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {

            node.right = remove(node.right, e);
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

            node.left = node.right =null;

            return successor;
        }
    }

}
