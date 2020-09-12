package Algorithm.Chapter2;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

/*
 * 	快速排序：应用非常广泛的排序算法。
 * 	优点：①实现简单；②适用于各种不同的输入数据且在一般应用中比其他排序算法更快；③原地排序（只需要一个很小的辅助数组aux）④ O(N)=NlogN;
 * 	缺点：脆弱，要小心才能避免造成性能低下；比如：第一个元素就是最小的元素，第二个元素是第二小的元素。。。导致的切分不平衡，效率低下。
 *
 * 	基本思路 分治思想：
 * 	1）将数组切分成两部分，切分元素为参考对象。
 * 	2）切分元素的左侧子数组的每个元素都要 ≤ 切分元素；
 * 	3）切分元素的右侧子数组的每个元素都要 ≥ 切分元素；
 * 	4）完成切分后，左子数组/右子数组分别继续切分（重复以上步骤）直到子数组只剩1个元素结束
 *
 *
 * 	怎么确定切分元素？ 	默认每个数组的第一个元素为切分元素
 * 	怎么确定切分元素的最终位置？
 * 		1）左指针i 从数组的第二个位置（索引1）向右扫描，找到比切分元素大的元素
 * 		2）右指针j 从数组的最后一个位置（索引a.length-1）向左扫描，找到比切分元素小的元素
 * 		3）交换这两个元素位置，然后分别继续扫描；
 * 		4）直到，i >= j 扫描结束
 * 		5）交换切分元素和左子数组的最后一个元素位置，此时切分元素的位置确定。
 *
 * 	和归并排序的区别？
 * 	1)归并 是数组长度对半分组、是先将两个子数组分别排序 再归并成一个数组；
 * 	2)快速排序分组是分成随机长度大小的两个子数组，却决于切分元素的内容。
 * 	3)两者的算法效率，快速排序比归并的更快，虽然运行时间都是NlogN 但快速排序的更快（即使快速排序里的比较次数更多），
 * 	4)归并排序和希尔排序都更慢些因为他们在内循环里移动数据
 *
 * 	平均：O(N) = NlogN
 * 	最坏：O(N) = N²/2
 *
 */
public class QuickSortDemo {

    public static void main(String[] args) {
        Integer[] arr = {922, 1000, 2, -19, 76, -2, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));

        String[] str = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        sort(str);
        System.out.println(Arrays.toString(str));

    }

    public static void sort(Comparable[] a) {

        StdRandom.shuffle(a);//随机排序，作用;避免 第一个元素就是最小的元素，第二个元素是第二小的元素。。。导致的切分不平衡，效率低下。
        sort(a, 0, a.length - 1);

    }

    private static void sort(Comparable[] a, int lo, int hi) {

        if (lo >= hi) return;
        //确定切分元素的位置
        int p = partition(a, lo, hi);
        //左右两边分别排序
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);


    }

    private static int partition(Comparable[] a, int lo, int hi) {
        //指定数组的第一个元素为切分元素，和左右指针初始值
        Comparable v = a[lo];
        int i = lo, j = hi + 1;

        //主循环：找到切分元素的位置
        while (true) {
            //左指针i 从数组的第二个位置（索引1）向右扫描，找到比切分元素大的元素a[i]
            while (less(a[++i], v)) {
                if (i == hi) break;
            }
            //右指针j 从数组的最后一个位置（索引a.length-1）向左扫描，找到比切分元素小的元素
            while (less(v, a[--j])) {
                if (j == lo) break;
            }
            //到这一步说明，找到了两个元素
            //先判断是否满足主循环体的结束条件
            if (i >= j) break;
            //不满足结束条件则进行交换上面找到的两个元素位置
            exch(a, i, j);

        }
        //交换切分元素和左子数组的最后一个元素位置，此时切分元素的位置确定
        exch(a, lo, j);

        return j;
		/*
		 * 如果改成i++ j--的实现情况
		 * 注意i++ 先返原值 再i =i+1 什么时候自增1呢？再下一次运行时之前 或 当前状态发生改变前 自增1
		 * 这里i++在i找到＞v的元素时，less（a[i],v）返false，结束判断语句，当前状态即将结束，i= i+1 状态结束了 此时i已经自增1了
		 * 所以跳出循环后 指针指的位置都是下一个位置！
		 * 
		 * 而++i --j是先自增或自减1 再返回自增/自减后的值！ 在这里这个方法更简便更容易理解！
		 * 
		 * i++和++i 二者效率一致。
		 * 
		int i = lo+1, j = hi;
		//主循环：找到切分元素的位置
		while(true) {
			//左指针i 从数组的第二个位置（索引1）向右扫描，找到比切分元素大的元素a[i]
			while(less(a[i++],v)) {	
				if(i == hi) break;
			}
			//右指针j 从数组的最后一个位置（索引a.length-1）向左扫描，找到比切分元素小的元素
			while(less(v,a[j--])) {
				if(j == lo) break;
			}
			//到这一步说明，找到了两个元素
			//先判断是否满足主循环体的结束条件
			if((i-1) >= (j+1)) break;
			//不满足结束条件则进行交换上面找到的两个元素位置
			exch(a,i-1,j+1);
			
		}
		//交换切分元素和左子数组的最后一个元素位置，此时切分元素的位置确定
		exch(a,lo,j+1);
		
		return j+1;
		 */


    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    private static boolean less(Comparable v, Comparable w) {

        return v.compareTo(w) < 0;
    }


}
