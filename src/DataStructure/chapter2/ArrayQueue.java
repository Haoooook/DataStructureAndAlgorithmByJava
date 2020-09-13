package DataStructure.chapter2;

import DataStructure.chapter1.ArrayE;

/**
 * 数组队列 队首进 队尾出。
 * 直接用基于arrayE的数组逻辑
 *
 *  enqueue()   O(1)
 *  dequeue()   O(n) 均摊
 *  getFront()  O(1)
 *  getSize()   O(1)
 *  isEmpty()   O(1)
 *
 * @author Damon
 * @create 2020-09-12 22:34
 */
public class ArrayQueue<E> implements Queue<E> {
    private ArrayE<E> array;

    public ArrayQueue() {
        array = new ArrayE<>();
    }

    public ArrayQueue(int capacity) {
        array = new ArrayE<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("Front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1)
                res.append(',');
        }
        res.append("] tail");
        return res.toString();
    }
}
