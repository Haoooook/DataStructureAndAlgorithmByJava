package DataStructure.chapter5;

/**
 * 二分搜索树Binary Search Tree
 * <p>
 * 每个节点大于左子节点，小于右子节点；
 * 存储的数据必须有可比较性；(即 对泛型E添加限制条件 实现Comparable接口)
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
    private void add(Node node, E e) {
        //不考虑根节点为空情况，
        //判断根节点的数据是否与添加的元素一致？
        //判断左右子节点是否为空，并按特点放入；
        if (e.equals(node.e))
            return;

        else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }
        //如果左右子节点都不为空，那么继续往下判断比较找到为空的叶子节点
        if (e.compareTo(node.e) < 0)
            add(node.left, e);
        else
            add(node.right, e);
    }

    public void add(E e) {
        //判断根节点为空情况
        if (root == null) {
            root = new Node(e);
            size++;
        } else
            add(root, e);
    }


}
