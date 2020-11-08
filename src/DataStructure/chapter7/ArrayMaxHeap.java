package DataStructure.chapter7;

import DataStructure.chapter1.ArrayE;

/**
 * 基于动态数组实现最大堆（扩容问题由底层数组完成）
 * 用层序存储元素，元素顺序按大小排列，顺序及其索引如图"数组实现二叉堆.png"
 * 索引顺序（根据层序+元素大小顺序排列）：第一层的根为零，第二层左边为1，右边为2，第三层....
 *
 * @author Damon
 * @create 2020-11-08 11:06
 */
public class ArrayMaxHeap<E extends Comparable<E>> {

    private ArrayE<E> data;

    public ArrayMaxHeap(int capacity) {
        data = new ArrayE<>(capacity);
    }

    public ArrayMaxHeap() {
        data = new ArrayE<>();
    }

    //返回堆的元素个数
    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回当前元素的父亲节点的索引
    public int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index can't be 0");

        return (index - 1) / 2;
    }

    //返回当前元素的左子节点的索引
    public int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回当前元素的右子节点的索引
    public int rightChild(int index) {
        return index * 2 + 2;
    }

    //堆 添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize()-1);
    }

    /**
     * 上浮函数，用来和比新增加的元素小的交换
     * @param k 索引，新添加的元素的索引
     */
    private void siftUp(int k) {

    }
}