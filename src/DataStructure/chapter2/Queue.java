package DataStructure.chapter2;

/**
 * 模拟队列接口，需要实现的一般操作
 *
 * 队列：先进先出FIFO
 * 体现在：添加元素是依次添加，删除元素时从头开始，即满足先进去的先删掉。
 *
 * @author Damon
 * @create 2020-09-12 22:29
 */
public interface Queue<E> {
    //O(1)
    int getSize();

    //O(1)
    boolean isEmpty();

    //O(1)均摊
    //每次添加都在队尾tail
    void enqueue(E e);

    //O(n)
    //删除元素，从头开始
    E dequeue();

    //O(1)
    //查看队首元素
    E getFront();

}
