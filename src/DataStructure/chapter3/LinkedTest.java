package DataStructure.chapter3;

import org.junit.Test;

/**
 * 测试
 *
 * @author Damon
 * @create 2020-09-22 15:30
 */
public class LinkedTest {
    @Test
    public void testLinkedList() {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ll.addLast(i * 3 + 7);
            System.out.println(ll);
        }
        System.out.println("在index=3处插入100");
        ll.add(3, 100);
        System.out.println(ll);

        System.out.println("修改第3个元素为-8");
        ll.set(2, -8);
        System.out.println(ll);

        System.out.println("是否包含-2这个元素？ " + ll.contains(-2));
        System.out.println("是否包含10这个元素？ " + ll.contains(10));

        System.out.println("获取第3个元素是：" + ll.get(4));

        System.out.println(ll);
        System.out.println(ll.remove(2));
        System.out.println(ll);

        System.out.println("获得元素19的所引位置："+ll.getIndex(19));
        System.out.println(ll.removeElement(16));
        System.out.println(ll);

    }
}
