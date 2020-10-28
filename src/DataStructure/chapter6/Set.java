package DataStructure.chapter6;

/**
 * 集合
 * Set<E>
 *      void add(E) 不能添加重复元素
 *      void remove(E)
 *      boolean contains(E)
 *      int getSize()
 *      boolean isEmpty()
 *  
 *  有序集合 --->基于搜索树的实现
 *  无序集合 --->基于哈希表的实现
 * 
 * @author Damon
 * @create 2020-10-28 19:53
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
