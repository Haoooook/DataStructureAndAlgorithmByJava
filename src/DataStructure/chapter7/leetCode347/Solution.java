package DataStructure.chapter7.leetCode347;

import DataStructure.chapter7.PriorityQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * 347. 前 K 个高频元素
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前k高的元素。
 * <p>
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * <p>
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示:
 * 你可以假设给定的k总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) ,n是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * <p>
 * 使用我们实现的PriorityQueue解决问题
 *
 * @author Damon
 * @create 2020-11-09 22:41
 */
public class Solution {

    private class Freq implements Comparable<Freq> {

        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return 1;
            else if (this.freq > another.freq)
                return -1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        /*
        1.使用TreeMap来保存数组的值即频次 key=值 value=频率
          如果treeMap中没有这个元素就存上，并赋value=1
          如果treeMap里有这个值了，那么就频率加一 value + 1
         */
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        /*
        2.使用优先队列来对treeMap里的值进行排列并存储。
          怎么排列呢？根据题意：要求 出现频率前k高的元素 根本是要比较词出现的评率大小 即value的大小
          借助一个辅助类Freq 保存treeMap里的key和value，
          把treeMap里的key集合一一导入优先队列，
          因为要前k个元素因此优先队列至少要有k个元素，那么不到k个元素的时候优先队列直接添加元素
          如果超过了k个元素了，进行判断：添加进来的元素的频率如果大于优先队列的队首元素那么就出队队首元素
          再把这个频率大的这个元素入队
         */
        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (priorityQueue.getSize() < k)
                priorityQueue.enqueue(new Freq(key, map.get(key)));
            else if (map.get(key) > priorityQueue.getFront().freq) {
                priorityQueue.dequeue();
                priorityQueue.enqueue(new Freq(key, map.get(key)));
            }
        }
        /*
        3.最后 要返回List，使用LinkedList来接收优先队列的k个元素
          根据习惯，进行翻转（降序排列）
         */
        LinkedList<Integer> res = new LinkedList<>();
        while (!priorityQueue.isEmpty())
            res.add(priorityQueue.dequeue().e);
        Collections.reverse(res);
        return res;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 3, 2, 2, 2, 3, 2, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 6, 5, 6, 5};
        int k = 4;
        printList((new Solution()).topKFrequent(nums, k));

    }
}
