package DataStructure.chapter2;

/**
 * 模拟栈
 * @author Damon
 * @create 2020-09-12 18:06
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
