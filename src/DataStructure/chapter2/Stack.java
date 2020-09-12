package DataStructure.chapter2;

/**
 * 模拟栈接口，即栈一般要满足的操作
 * 栈的主要特点即：LIFO后进先出、FILo先进后出。
 * <p>
 * 实质是体现在：
 * 添加/推进(push)元素 和 删除/推出(pop)上面
 * 栈顶始终是最后一个进去，先出去（如数组的末尾端、数组里的最后一个元素位置）
 * 栈底始终是第一个进去的元素，最后一个出去的元素
 *
 * @author Damon
 * @create 2020-09-12 18:06
 */
public interface Stack<E> {
    //O(1)
    int getSize();

    //O(1)
    boolean isEmpty();

    //O(1) 均摊
    void push(E e);

    //O(1) 均摊
    E pop();

    //O(1)
    E peek();
}
