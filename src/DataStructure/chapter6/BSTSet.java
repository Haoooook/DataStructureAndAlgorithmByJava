package DataStructure.chapter6;

/**
 * 用BST结构实现set集合
 * set集合不能添加重复元素
 * <p>
 * 实现Set接口，泛型参数继承Comparable类，底层私有 new BST对象并进行操作
 *
 * @author Damon
 * @create 2020-10-28 20:10
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
