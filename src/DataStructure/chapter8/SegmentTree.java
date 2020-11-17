package DataStructure.chapter8;

/**
 * 线段树（区间树） 数组实现
 * 如果区间有n个元素，数组表示需要多少个节点？
 * 如果n=2^k 需要2n个空间
 * 最坏的情况 n=2^k+1, 需要4n的空间
 *
 * 因此 数组实现线段树 要开辟4n空间！
 *
 * @author Haoooook
 * @create 2020-11-17 21:56
 */
public class SegmentTree<E> {
    private E[] data;//数组，存储数据
    private E[] tree;//把内部的data数组组织成 树结构
    private Merger<E> merger;//用户定义好的合并方法

    public SegmentTree(E[] arr, Merger<E> merger) {

        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];

        tree = (E[]) new java.lang.Object[arr.length * 4]; //4n的空间是能容纳最坏情况下

        //构造线段树对象时 初始化底层树结构并存入数据。
        //初始化时，从索引位置为0的根节点开始，创建【0，data.length-1】的区间
        bulidSermentTree(0, 0, data.length - 1);

    }

    /**
     * 在treeIndex索引位置创建一个区间【l,r】的线段树
     * 只有叶子节点是区间长度为1的线段树
     * 递归实现
     *
     * @param treeIndex 索引
     * @param l         区间下限l
     * @param r         区间上限r
     */
    private void bulidSermentTree(int treeIndex, int l, int r) {
        //递归终止条件 到达叶子节点时停止
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        // int mid = (l + r) / 2; 或下面的
        int mid = l + (r - l) / 2;

        bulidSermentTree(leftTreeIndex, l, mid);
        bulidSermentTree(rightTreeIndex, mid + 1, r);

        //实现以下逻辑，
        //tree[treeIndex] = tree[leftTreeIndex]+ tree[rightTreeIndex];
        //但是E 的数据类型不一定能 "+" 因此需要实现一个接口功能函数实现'合并' 具体的怎么实现合并由用户提供，传参merge
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal !");
        return data[index];
    }

    /**
     * 索引index对应的节点 他的左子节点的索引
     *
     * @param index 目标节点的索引
     * @return 目标节点的左子节点 对应的索引值
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 索引index对应的节点 他的右子节点的索引
     *
     * @param index 目标节点的索引
     * @return 目标节点的右子节点 对应的索引值
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[ ");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("NULL");
            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(" ]");
        return res.toString();
    }

}
