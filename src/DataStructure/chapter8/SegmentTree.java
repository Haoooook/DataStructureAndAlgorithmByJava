package DataStructure.chapter8;

/**
 * 线段树（区间树） 数组实现
 * 如果区间有n个元素，数组表示需要多少个节点？
 * 如果n=2^k 需要2n个空间
 * 最坏的情况 n=2^k+1, 需要4n的空间
 * <p>
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
        //初始化 用户定义的merge方法
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

    //返回目标区间【queryL，queryR】的值
    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryR < 0 || queryL >= data.length || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("The query index are illegal !");
        //初始化里，从根节点开始（索引值为0）在整个区间【L,R】内查询 目标区间【queryL，queryR】
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /**
     * 查询目标区间【queryL，queryR】的值
     *
     * @param treeIndex 起始的节点的索引
     * @param l         查询范围区间的下限
     * @param r         查询范围区间的上限
     * @param queryL    要查询的区间下限
     * @param queryR    要查询的区间上限
     * @return 目标区间【queryL，queryR】的值
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        //递归终止条件
        if (l == queryL && r == queryR)
            return tree[treeIndex];

        int mid = l + (r - l) / 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) //目标区间全在右子树
            return query(rightIndex, mid + 1, r, queryL, queryR);
        else if (queryR <= mid) //目标区间全在左子树
            return query(leftIndex, l, mid, queryL, queryR);

        //目标区间横跨两个子树 通过merger接口对象实现合并
        E leftResult = query(leftIndex, l, mid, queryL, mid);
        E rightResult = query(rightIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftResult, rightResult);

    }

    /**
     * 通过索引修改元素
     * @param index 目标的位置索引
     * @param e 修改值
     */
    public void set(int index, E e) {
        if (index < 0 || index > data.length)
            throw new IllegalArgumentException("Index is illegal !");

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {

        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);

        if (index >= mid + 1)
            set(rightIndex, mid + 1, r, index, e);
        else
            set(leftIndex, l, mid, index, e);

        tree[treeIndex] = merger.merge(tree[leftIndex], tree[rightIndex]);
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
