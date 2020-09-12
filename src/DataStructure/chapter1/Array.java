package DataStructure.chapter1;

/*
 * 	模拟Java数组的底层实现逻辑
 */
public class Array {

    private int[] data;
    private int size;

    /**
     * 指定要创建capacity大小的数组
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 默认不指定数组大小时候 指定大小10
     */
    public Array() {
        this(10);
    }

    //获得数组中有多少个元素
    public int getSize() {
        return size;
    }

    //获得数组的空间大小
    public int getCapacity() {
        return data.length;
    }

    int get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get() failed, Require index >= 0 || index < size");
        return data[index];
    }

    void set(int index, int e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set() failed, Require index >= 0 || index < size");
        data[index] = e;
    }

    /*
     * 	在指定位置添加元素
     * 	指针从后往前，前一个元素往后一个元素放，直到指针走到目标位置，放入要插入的元素
     *
     * 	size指数组里有多少个元素 是从1开始计数 是指向数组中第一个没有元素的位置
     * 	比如： 0~3都有元素 元素个数为4，size=4 指向数组中第一个没有元素的位置即第四个位置
     *
     * 	capacity指数组的容量（包含没有元素的位置）也是从1开始计数
     * 	数组的索引及指针 从0开始计数
     */
    public void add(int index, int e) {
        if (size == data.length)
            throw new IllegalArgumentException("add() failed, Array is full!");

        if (index < 0 || index > size)
            throw new IllegalArgumentException("add() failed, Require index >= 0 || index <= size");

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //在末尾添加元素
    public void addLast(int e) {
        add(size, e);
    }

    //在第一个位置添加元素
    public void addFirst(int e) {
        add(0, e);
    }

    //是否包含元素e?
    boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return true;
        }
        return false;

    }

    //查找元素e的位置（索引）
    int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e)
                return i;
        }
        return -1;
    }

    /*
     * 删除指定位置的元素
     * 返回int类型，即返回删除的元素
     */
    int remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove() failed, index is illegal!");
        int ret = data[index];

        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;

        return ret;

    }

    int removeFirst() {
        return remove(0);
    }

    int removeLast() {
        return remove(size - 1);
    }

    void removeElement(int e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        result.append('[');
        for (int i = 0; i < size; i++) {
            result.append(data[i]);

            if (i != size - 1)//指针不到最后一个元素的位置就加，
                result.append(", ");
        }
        result.append(']');
        return result.toString();
    }

}
