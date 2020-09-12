package DataStructure.chapter1;

/*
 * 	模拟Java数组的底层实现逻辑
 * 	加入泛型 适应更多的数据类型（不包括基本数据类型但包括他们的包装类）
 *  添加动态数组的自动扩容方法 reSize（）
 */
public class ArrayE<E> {

    private E[] data;
    private int size;

    /**
     * 指定要创建capacity大小的数组
     */
    @SuppressWarnings("unchecked")
    public ArrayE(int capacity) {
        data = (E[]) new Object[capacity];//java不支持new泛型数组，需强转
        size = 0;
    }

    /**
     * 默认不指定数组大小时候 指定大小10
     */
    public ArrayE() {
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

    E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("get() failed, Require index >= 0 || index < size");
        return data[index];
    }

    void set(int index, E e) {
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
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("add() failed, Require index >= 0 || index <= size");

        if (size == data.length) {
            //ArrayList中是自动扩容1.5倍,这里我们扩大2倍
            //int newCapacity = oldCapacity + (oldCapacity >> 1);
            reSize(data.length << 1);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void reSize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        for (int i = 0; i < size; i++)
            /*
            为什么这里不是<data.length?
            因为如果<data.length就是小于数组的容量，在add（）方法里没问题
            但是在自动缩小扩容的时候，会出现ArrayIndexOutOfBoundsException数组索引越界
            因为已经检验索引不能大于等于size，如果把空值也复制进来索引就超过size，报异常
             */
            newData[i] = data[i];
        //把data中的元素复制完之后，把data对象的指向赋给newData对象，完成替换
        //剩下的data对象等待GC回收
        data = newData;

    }

    //在末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //在第一个位置添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //是否包含元素e?
    boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) //针对泛型的元素e，不能用基本数据类型的==比较 而是继承于Object的equals方法
                return true;
        }
        return false;

    }

    //查找元素e的位置（索引）
    int find(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i]))
                return i;
        }
        return -1;
    }

    /*
     * 删除指定位置的元素
     * 返回int类型，即返回删除的元素
     *
     * 原理：从index+1处的元素开始到最后一个元素，依次向前移一位（覆盖前一个元素）
     * 最后会出现两个最后一个元素，size指针向前移一位，第二个相同的元素不用管不会展示给用户。
     * 但实现了泛型，为了释放空间可以设为null
     */

    E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove() failed, index is illegal!");
        E ret = data[index];

        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;

        //加入泛型后 元素都是对象，原数组的最后一个元素是一只保留的他的值是这个元素对象的引用，GC不会清除掉
        //为了释放空间，可以把原数组的最后这个元素值设null
        data[size] = null;

        //删除元素之后查看元素个数是否等于元素容量的1/4
        //如果等于1/4了则进行缩小数组容量data.length大小1/2，防止复杂度震荡
        if (size == data.length / 4 && data.length / 2 != 0)
            reSize(data.length / 2);

        return ret;

    }

    E removeFirst() {
        return remove(0);
    }

    E removeLast() {
        return remove(size - 1);
    }

    void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
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
