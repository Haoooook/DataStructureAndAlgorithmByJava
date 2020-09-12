package Algorithm.Chapter2;

/*
 * 希尔排序
 *
 * 在插入排序的基础上进行优化，
 * 插入排序是交换相邻的元素，如果要交换到末端或很远的位置只能一点一点的交换过去，交换次数较大
 * 希尔排序优化点在于，使任意间隔的元素可以比较然后直接插入排序更换位置，使得减少交换次数。且间隔的大小对半减小直至为1。
 * 实质是 先宏观上大致有序->具体有序
 *
 * 初始的间隔h大小怎么确定？ 一般是要排序的数组的长度的整数倍，整数>=1；
 *
 */
public class ShellDemo {
//		以升序为例

    public static void shellSorted(Comparable[] arr) {
        if (isSorted(arr) == false) {
            int N = arr.length;
            int h = 1;
            while (h < N / 3) h = h * 3 + 1;
            while (h >= 1) {
                for (int i = h; i < N; i++) {
                    for (int j = i; j >= h && less(arr[j], arr[j - h]); j -= h) {
                        exch(arr, j, j - h);
                    }
                }
                h = h / 3;
            }
            show(arr);
        }

        System.out.println("已有序");
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] arr, int n, int m) {
        Comparable temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }

    public static boolean isSorted(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (less(arr[i], arr[i + 1])) return false;
        }
        return true;
    }

    public static void show(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        Integer[] arr = {922, 1000, 2, -19, 76, -2, 0};
        shellSorted(arr);

    }

}
