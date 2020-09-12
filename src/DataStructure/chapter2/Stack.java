package DataStructure.chapter2;

/**
 * 模拟栈接口，即栈一般要满足的操作
 *
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
