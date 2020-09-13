package DataStructure.chapter2;

import org.omg.CORBA.Object;

/**
 * 模拟循环队列
 * 是什么？
 *      一个空间为c的队列，两个指针队首指针front和队尾指针tail；
 *      在front == tail 时队列为空了；
 *      在front == （tail+1）% c 时队列满了，自动扩容队列空间；（即刻意的浪费一个空间）
 * 区别于数组队列
 *  实现Queue接口，重写实现方法
 *
 *  enqueue()   O(1) 均摊
 *  dequeue()   O(1) 均摊
 *  getFront()  O(1)
 *  getSize()   O(1)
 *  isEmpty()   O(1)
 *
 * @author Damon
 * @create 2020-09-13 13:26
 */
public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];//循环队列要浪费一个空间
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {

        if ((tail + 1) % data.length == front)
            reSize(getCapacity() * 2);

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void reSize(int newCapacity) {
        E[] newData = (E[]) new java.lang.Object[newCapacity+1];
        for (int i = 0; i < size; i++)
            newData[i] = data[(i + front) % data.length];
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("dequeue() is failed,the queue is empty!");

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            reSize(getCapacity() / 2);

        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("The queue is empty!");

        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("Front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(',');
        }
        res.append("] tail");
        return res.toString();
    }
}
