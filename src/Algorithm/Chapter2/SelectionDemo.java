package Algorithm.Chapter2;


/*选择排序实现模板
 * 原理：
	   1.找到数组中最小的那个元素，
	   2.将它和数组的第一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。
	   3.在剩下的元素中找到最小的元素，将它与数组的第二个元素交换位置。
	   如此往复，直到将整个数组排序。这种方法叫做选择排序，因为它在不断地选择剩余元素之中的最小者。
	 	
 		我们的排序算法模板适用于任何实现了Comparable接口的数据类型。遵守Java 惯例的好处是很多你希望排序的数据都实现了Comparable 接口。
	 	例如，Java 中封装数字的类型Integer 和Double，以及String 和其他许多高级数据类型（如File 和URL）都实现了Comparable接口。
	 	因此你可以直接用这些类型的数组作为参数调用这个排序方法
		
		在v.compareTo(w) 被调用时分别返回一个负整数、零和一个正整数（一般是-1、0 和1）。
		v 和w 无法比较或者两者之一是null，v.compareTo(w) 将会抛出一个异常
 
	 选择排序的内循环只是在比较当前元素与目前已知的最小元素（以及将当前索引加1 和检查是否代码越界）
	 交换元素的代码写在内循环之外，每次交换都能排定一个元素，因此交换的总次数是N。所以算法的时间效率取决于比较的次数。
	 
	 对于长度为N 的数组，选择排序需要大约N²/2次比较 和 N次交换
 
 	每次交换都会改变两个数组元素的值，因此选择排序用了N 次交换：交换次数和数组的大小是线性关系。数据移动是最少的。
 
 */
public class SelectionDemo {
    //升序排列
    public static void SelectSrotT(Comparable[] arr) {
        if (isSorted(arr) == false) {
            int N = arr.length;
            for (int i = 0; i < N; i++) {
                int min = i;
                for (int j = i + 1; j < N; j++)
                    if (less(arr[j], arr[min])) min = j;

                exch(arr, i, min);

            }
            show(arr);
            System.out.println();
        }
        System.out.println("已是有序的");

    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr = {922, 1000, 2, -19, 76, -2, 0};
        SelectSrotT(arr);

        String[] str = {"E", "A", "S", "Y", "Q", "U", "E", "S", "T", "I", "O", "N"};
        SelectSrotT(str);


    }

}
