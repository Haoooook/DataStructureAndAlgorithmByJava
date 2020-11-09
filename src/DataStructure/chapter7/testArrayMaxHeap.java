package DataStructure.chapter7;

import java.util.Random;

/**
 * 测试最大堆的效果
 *
 * @author Damon
 * @create 2020-11-08 17:41
 */
public class testArrayMaxHeap {
    public static void main(String[] args) {
        int n = 1000000;

        ArrayMaxHeap<Integer> arrayMaxHeap = new ArrayMaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++)
            arrayMaxHeap.add(random.nextInt(Integer.MAX_VALUE));

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = arrayMaxHeap.extractMax();

        //把堆的每一个元素都放到arr中，那么arr数组就应该是一个降序的数组
        //判断相邻两个元素值大小只要前面的小于后面的就是出错了，不小于那么就是最大堆成功了
        for (int i = 1; i < n; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error!");

        System.out.println("ArrayMaxHeap is completed!");

    }
}
