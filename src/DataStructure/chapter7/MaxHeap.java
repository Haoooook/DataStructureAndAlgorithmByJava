package DataStructure.chapter7;

/**
 * 二叉堆 是完全二叉树
 * 每个节点是comparable对象
 * 二叉堆的每个节点的值都不小于（或不大于）其任意一个子节点或子节点的子节点的值；节点的子树之间没有关系。
 *
 * @author Damon
 * @create 2020-11-08 10:52
 */
public interface MaxHeap<E extends Comparable<E>> {

    void add(E newEntry);

    E removeMax();

    E getMax();

    boolean isEmpty();

    int getSize();

    void clear();

}
