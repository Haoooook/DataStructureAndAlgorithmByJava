package Algorithm.Chapter2;

import java.util.Arrays;

/*
 *	自底向上的原地归并排序：
 *	1）把每个子数组当成只有一个元素的数组，进行两两归并merge（）
 *	2）即规模为1：相怜的两个元素分别是元素为1的数组，归并
 *	3）规模为2：相邻的两个元素为一个数组，和另一个同样规模的数组归并
 *	4）规模为4：....
 *	5）规模数值<数组长度
 *
 * 	O(N) = NlogN
 * 	两个归并排序的效率差距在常数级别内
 * 	更适用于：数据是 链表linked list类型的数据结构
 *
 */
public class MergeDemo2 {

    public static void main(String[] args) {
        Integer[] arr = {922, 1000, 2, -19, 76, -2, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        String[] str = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(str);
        System.out.println(Arrays.toString(str));
    }

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        //一次性创建好辅助函数的长度即为原数组的长度
//		Comparable[] aux = new Comparable[a.length];	为什么这么写会报空指针异常？
        int N = a.length;
        aux = new Comparable[N];

        //规模从1开始 成倍增加 但要小于原数组的长度
        for (int size = 1; size < N; size = size + size) {
            //用首位元素的索引表示mid、hi
            //每个lo间隔两个规模值
            for (int lo = 0; lo < N - size; lo += size + size) {
                //每个mid就应该当前两个要归并的数组的第一个数组的 首位索引+1个规模-1
                //每个hi就应该是当前两个要归并的数组第一个数组的 首位索引+2个规模-1，但是：这个值可能会超过原数组最后一个元素的索引
                //因此，选择最小的那个
                //比如，长度为17的数组，规模到达4的时候，最后会剩3个元素，此时的索引就是hi=18,索引就越界了，
                merge(a, lo, lo + size - 1, Math.min(lo + size + size - 1, N - 1));
            }
        }


    }

    //递归：将数组元素不断对半分组，并将子数组进行归并排序merge（a[],lo,mid,hi）
    public static void sort(Comparable[] a, int lo, int hi) {

        //递归结束条件
        if (lo >= hi) return;

        //右移位2 即乘1/2
        int mid = (hi + lo) / 2;

        //左右两个数组分别不断对半分组，直至每个子数组只剩一个元素 满足lo >= hi条件 结束递归，
        //然后返回到上一个sort()方法，此时因为有返回值了就结束了，然后进行下一步merge（a,lo,mid,hi)排序,
        //排序结束后继续返回到它的上一个sort（）方法,此时因为有返回值了就结束了，依次往复
        //直到完成所有sort（）
        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        merge(a, lo, mid, hi);


    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        //将原数组的元素完全复制给辅助数组
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        //归并到原数组
        for (int k = lo; k <= hi; k++) {
            //左半数组全部放入原数组，即左半数组为空了
            //右半数组有剩余/甚至没动过就整体把右半有序数组放入原数组剩下位置
            if (i > mid) a[k] = aux[j++];

                //右半数组全部放入原数组，即右半数组为空了
                //左半数组有剩余/甚至没动过就整体把左半有序数组放入原数组剩下位置
            else if (j > hi) a[k] = aux[i++];

                //两个有序的数组的元素进行依次比较，更小的放入原数组
            else if (less(aux[i], aux[j])) a[k] = aux[i++];

            else a[k] = aux[j++];

        }


    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

}
