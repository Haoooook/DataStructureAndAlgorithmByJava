package Algorithm.Chapter2;

/*
 * 插入排序
 * 原理：
	1）默认第一个元素为最小值
	2）指针指向第2个元素，前两个元素看成一个子列表，拿第2个元素和第一个元素比较大小；
	3）指针指向第3个元素，前3个元素看成一个子列表，拿第3个元素和前两个比大小并交换；
	4）直到指针指向数组的最后，比较大小和交换，结束。
 * 
 	插入排序所需的时间取决于输入中元素的初始顺序。例如对一个很大且其中的元素已经有序（或接近有序）的数组进行排序将会比对随机顺序的数组或是逆序数组进行排序要快得多。

 	对于随机排列的长度为N 且元素不重复的数组，
 	平均情况下插入排序需要～ N²/4 次比较以及～ N²/4 次交换。
 	最坏情况下需要～ N²/2 次比较和～ N²/2 次交换，最好情况下需要N-1次比较和0 次交换。
 	
 	插入排序对于实际应用中常见的某些类型的非随机数组很有效。
 * 
 * 
 */
public class InsertDemo {
    //升序排列
    public static void insertSrot(Comparable[] arr) {
        if (isSorted(arr) == false) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                    exch(arr, j, j - 1);
                }
            }
            show(arr);
        } else System.out.println("已有序");
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (less(arr[i], arr[i + 1])) return false;
        return true;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }

    public static void exch(Comparable[] arr, int m, int n) {
        Comparable temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {922, 1000, 2, -19, 76, -2, 0};
        insertSrot(arr);


    }

}
