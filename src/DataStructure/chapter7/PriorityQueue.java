package DataStructure.chapter7;

import DataStructure.chapter2.Queue;

/**
 * 基于 数组实现的最大堆 实现优先队列
 *
 * @author Damon
 * @create 2020-11-09 23:02
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private ArrayMaxHeap<E> arrayMaxHeap;

    public PriorityQueue() {
        arrayMaxHeap = new ArrayMaxHeap<>();
    }

    @Override
    public int getSize() {
        return arrayMaxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayMaxHeap.isEmpty();
    }

    /**
     * 获得队首元素 即堆的堆顶元素（最大元素）
     *
     * @return
     */
    @Override
    public E getFront() {
        return arrayMaxHeap.findMax();
    }


    @Override
    public void enqueue(E e) {
        arrayMaxHeap.add(e);
    }

    /**
     * 出队 即先进的先出 出堆顶元素（最大元素）
     *
     * @return 堆顶元素
     */
    @Override
    public E dequeue() {
        return arrayMaxHeap.extractMax();
    }
}
