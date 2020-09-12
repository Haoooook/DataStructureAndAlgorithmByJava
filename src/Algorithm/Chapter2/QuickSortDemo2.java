package Algorithm.Chapter2;

import java.util.Arrays;

/*
 *	快速排序的改进
 *	解决：输入的数据中有重复元素（较多甚至全是重复元素）情况下依然递归，降低效率问题。
 *
 *	三向切分快速排序：
 *	1）[lo,lt-1] 小于v的元素
 *	2）[lt,gt] 等于v的元素
 *	3）[gt+1,hi] 大于v的元素
 *	优化的基本思想就是把和v一样的元素忽略掉（不进行递归、交换等操作提高排序效率）
 *
 *	实现过程：
 *	1）需要三个指针，lt为低指针，gt为高指针，i为遍历的当前元素的指针
 *	2）指定第一个元素为v，lt初始值为lo，hi初始值为hi，
 *	3）i从第二个元素开始遍历，
 *	4）如果找到比v小的，那么a[i]和a[lt]交换位置，然后i++，lt++ 两指针各自移位1次；
 *	5）如果 找到比v大的，那么a[i]和a[gt]互换位置，然后i++,gt-- 两指针各自移位1次;
 *	6）如果找到和v一样大小的元素，那么忽略，i++，去看下一个元素；
 *	7）结束条件，i <= gt,表示i已经遍历完，
 *	8）此时只是将 和当前的v一样的元素找到并放置到[lt,gt]里，在[lo,lt-1] 以及 [gt+1,hi]这两个子数组中都是比v小、大的无序数组；
 *	9）分别递归即可。
 *
 */
public class QuickSortDemo2 {

    public static void main(String[] args) {
        Integer[] arr = {922, 1000, 2, -19, 76, -2, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        String[] str = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(str);
        System.out.println(Arrays.toString(str));

    }

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {

        //递归结束条件
        if (lo >= hi) return;

        Comparable v = a[lo];
        int lt = lo, i = lo + 1, gt = hi;

        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) exch(a, lt++, i++);
            else if (cmp > 0) exch(a, i, gt--);
            else i++;

        }

        //[lt,gt]之前为等于v的元素，不需要排序
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);

    }

    private static void exch(Comparable[] a, int v, int w) {
        Comparable temp;
        temp = a[v];
        a[v] = a[w];
        a[w] = temp;
    }

}
