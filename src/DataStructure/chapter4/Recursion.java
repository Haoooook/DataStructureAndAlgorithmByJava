package DataStructure.chapter4;

import org.junit.Test;

/**
 * *递归
 * 本质上：把原来的问题转化为更小的同一问题
 * 举例：数组求和
 * Sum(arr[0.....n-1]) = arr[0] + Sum(arr[1...n-1])
 * Sum(arr[1.....n-1]) = arr[1] + Sum(arr[2...n-1])
 * ...
 * Sum(arr[n-1.....n-1]) = arr[n-1] + Sum([]) = arr[n-1] + 0
 * 逐渐把复杂的问题拆分成小问题。。。直到找到最基本问题
 * 每解决一个小问题就可以向上解决每个 大一些的问题直到解决原复杂的问题
 * <p>
 * 递归函数，即函数 完成一个功能
 * <p>
 * 链表天然的递归性
 * 0->1->2->3->4->null
 * 理解为：
 * 0->『一个更短的链表（少了一个节点）』->null
 * 0->1->『一个更短的链表（少了两个节点）』->null
 * ...
 * 0->1->2->3->4->null
 *
 * @author Damon
 * @create 2020-10-20 20:09
 */
public class Recursion {

    //递归实现例子：数组求和
    public int sum(int[] arr) {
        return sum(arr, 0);
    }

    //递归实现arr[l....n]的求和
    private static int sum(int[] arr, int l) {
        if (l == arr.length)
            return 0;
        return arr[l] + sum(arr, l + 1);
    }

    @Test
    public void testSumArr() {
        int[] arr = {-1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(sum(arr));

    }
}
