package DataStructure.chapter1;

import org.junit.Test;

/**
 * 测试类
 *
 * @author Damon
 * @create 2020-09-12 12:39
 */
public class ArrayTest {

    @Test
    public void TestArray() {
        Array arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        System.out.println(arr);//打印对象 自动调用toString()方法

        arr.addFirst(97);
        System.out.println(arr);

        arr.addLast(-189);
        System.out.println(arr);

        System.out.println("\narr数组的第8个元素是：" + arr.get(7));
        System.out.println();

        arr.set(6, -3);
        System.out.println(arr);

        System.out.println("arr是否有19这个元素？ " + arr.contains(19));

        System.out.println("arr里-2这个元素的位置？ " + arr.find(-2));
        System.out.println("arr里-3这个元素的位置？ " + arr.find(-3));

        System.out.println("===========================================");
        System.out.println(arr);
        System.out.println("删除第2个位置的元素：" + arr.remove(1));
        System.out.println(arr);

        arr.removeElement(7);
        System.out.println(arr);

    }

    @Test
    public void TestArrayE() {
        ArrayE<Integer> arr = new ArrayE<>(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        System.out.println("==================测试基本操作====================");
        System.out.println(arr);

        arr.addFirst(97);
        System.out.println(arr);

        arr.addLast(-189);
        System.out.println(arr);

        System.out.println("arr数组的第8个元素是：" + arr.get(7));

        arr.set(6, -3);
        System.out.println(arr);

        System.out.println("arr是否有19这个元素？ " + arr.contains(19));
        System.out.println("arr里-2这个元素的位置？ " + arr.find(-2));
        System.out.println("arr里-3这个元素的位置？ " + arr.find(-3));
        System.out.println(arr);

        System.out.println("删除第2个位置的元素：" + arr.remove(1));
        System.out.println(arr);

        arr.removeElement(7);
        System.out.println(arr);

        System.out.println("===============测试自动扩容=====================");
        for (int j = 0; j < 50; j++)
            arr.addLast(4 * j);
        System.out.println(arr);

        System.out.println("===============测试自动减容=====================");
        for (int k = 0; k < 40; k++)
            arr.removeLast();
        System.out.println("这里删除了40个元素，剩20个元素 = 1/4capacity 进行自动减容 避免出现多次reSize()操作提高效率");
        System.out.println(arr+"\n");

        for(int n = 0; n < 20; n ++)
            arr.removeLast();
        System.out.println("这里减到剩10个的时候为1/4capacity，触发reSize()减半为20。。。继续减数量，容量继续减半直到容量减为1");
        System.out.println(arr);

    }


}
