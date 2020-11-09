package DataStructure.chapter7;

import DataStructure.chapter1.ArrayE;

/**
 * 二叉堆 是完全二叉树
 * 每个节点是comparable对象
 * 二叉堆的每个节点的值都不小于（或不大于）其任意一个子节点或子节点的子节点的值；节点的子树之间没有关系。
 *
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

    /**
     * 传入一个数组直接进行二叉堆化。
     *
     * @param arr 传入的数组
     */
    public void ArrayMaxHeap(E[] arr) {
        data = new ArrayE<E>(arr);
        if (arr.length != 1) {
            for (int i = parent(arr.length - 1); i >= 0; i--)
                siftDown(i);
        }
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

    /**
     * 堆 添加元素
     * 添加到末尾，然后进行元素比大小交换
     * 怎么交换？索引位置上的互换
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 元素值上浮函数，用来和比新增加的元素小的交换
     * 每个比新增元素小的元素都需要互换。
     *
     * @param k 索引，新添加的元素的索引
     */
    private void siftUp(int k) {

        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 获得堆的最大元素
     *
     * @return
     */
    public E findMax() {
        if (data.isEmpty())
            throw new IllegalArgumentException("Can't findMax when the heap is empty!");
        return data.get(0);
    }

    /**
     * 取出堆顶元素（取出堆的最大元素）
     * 1.取出堆顶元素，
     * 2.把数组的末尾元素覆盖掉原堆顶元素并删除末尾元素
     *
     * @return 堆顶元素/堆的最大元素
     */
    public E extractMax() {
        E ret = findMax();

        //把数组的末尾元素放到堆顶元素
        data.swap(0, data.getSize() - 1);
        data.removeLast();

        siftDown(0);

        return ret;
    }

    /**
     * 元素下沉函数
     * 元素向下和其左右子节点中最大的那个进行比较大小并互换，
     * 不断向下（下沉）直到其子节点没有比他大的。即堆完成
     *
     * @param k
     */
    private void siftDown(int k) {
        //如果k索引对应的节点没有子节点了，那就直接结束。
        //如果k索引对应的节点有子节点 即 左节点索引比数组大小要小（右子节点的索引比左子节点的索引大的）
        while (leftChild(k) < data.getSize()) {
            //找到k的左右子节点中比k对应的元素大的那个

            //索引k肯定有左子节点，不一定有右子节点。
            int j = leftChild(k);
            //判断如果有右子节点，因为左子节点的索引+1即他这一层的右子节点索引
            //如果右子节点的元素比左子节点元素大，那么 把指针j指向右子节点
            if (j + 1 < data.getSize()
                    && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j++;
            }
            //找到了k的左右子节点里大的那个，那么和k的元素比较看谁更大
            //如果k的对应的元素更大 那就不用更换 直接结束，
            //如果小了，那就else里 进行互换即可
            if (data.get(k).compareTo(data.get(j)) >= 0)
                break;
            else {
                //交换了，要把k往下沉，比较更小的子树，重复上面的找更大的子节点比大小步骤
                data.swap(k, j);
                k = j;
            }
        }
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     *
     * @param e 替换后的新值
     * @return 返回堆中的最大元素
     */
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

}