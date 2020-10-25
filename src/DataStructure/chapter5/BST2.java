package DataStructure.chapter5;

/**
 * 二分搜索树Binary Search Tree
 * <p>
 * 每个节点大于左子节点，小于右子节点；
 * 存储的数据必须有可比较性；(即 对泛型E添加限制条件 实现Comparable接口)
 * <p>
 * <p>
 * 改进：在add（）里优化臃肿的递归条件,使递归到为空的叶子节点终止
 *
 * @author Damon
 * @create 2020-10-25 13:05
 */
public class BST2<E extends Comparable> {

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

    public BST2() {
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

    public void add(E e) {
        root = add(root, e);
    }

}
