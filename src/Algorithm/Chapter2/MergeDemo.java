package Algorithm.Chapter2;

import java.util.Arrays;

/*
 *	一般的归并排序：是使用额外的空间（创建额外的适当大小的数组），将两个不同的有序数组归并到第三个数组中。
 *		1）优点：对于N长度的数组，时间复杂度和Nlog(N)正比
 *		2）缺点：牺牲了空间，所需要的空间和N成正比。
 *
 *	自顶向下的原地归并排序：
 *	1）创建一个辅助数组aux[],把原数组copy到辅助数组；
 *	2）对aux[]进行对半分组，前一半数组和后一半数组分别排序（调用sort（）递归排序）
 *	4）sort（）递归排序：将数组元素不断对半分组，直至分成每个数组只有一个元素然后分别两两对比大小排序并合并成一个数组；
 *	3）最后的两个子数组排序完成后，
 *		1）对两个子数组的元素从头到尾分别遍历比较大小，依次放入原数组，
 *		1）若左半数组元素排序完成，右半数组有剩余（甚至一个没动）则右半数组整体放入原数组剩下位置；
 *		2）若右半数组元素排序完成，左半数组有剩余（甚至一个没动）则左半数组整体放入原数组剩下位置；
 *
 * 	O(N) = NlogN
 *
 */
public class MergeDemo {

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
        aux = new Comparable[a.length];
        //开始调用重载的递归方法
        sort(a, 0, a.length - 1);

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
