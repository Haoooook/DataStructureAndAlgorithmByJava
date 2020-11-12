package DataStructure.chapter7.leetCode347;

import java.util.*;

/**
 * 用java内置的java.util.PriorityQueue 底层是最小堆
 *
 * add          增加一个元索                       如果队列已满，则抛出一个IIIegaISlabEepeplian异常
 * remove       移除并返回队列头部的元素            如果队列为空，则抛出一个NoSuchElementException异常
 * element      返回队列头部的元素                 如果队列为空，则抛出一个NoSuchElementException异常
 * offer        添加一个元素并返回true             如果队列已满，则返回false
 * poll         移除并返问队列头部的元素            如果队列为空，则返回null
 * peek         返回队列头部的元素                 如果队列为空，则返回null
 * put          添加一个元素                      如果队列满，则阻塞
 * take         移除并返回队列头部的元素            如果队列为空，则阻塞
 *
 * @author Damon
 * @create 2020-11-11 22:42
 */
public class Solution2 {

    private class Freq implements Comparable<Freq> {

        public int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        /*
        java.util.PriorityQueue的底层是最小堆 判断大小的逻辑需变更
         */
        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return -1;
            else if (this.freq > another.freq)
                return 1;
            else
                return 0;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
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
            if (priorityQueue.size() < k)
                priorityQueue.add(new Freq(key, map.get(key)));
            else if (map.get(key) > priorityQueue.peek().freq) {
                priorityQueue.poll();
                priorityQueue.add(new Freq(key, map.get(key)));
            }
        }
        /*
        3.最后 要返回int[]，分别弹出队列的队首元素放入int[] ret 来接收优先队列的k个元素
         */
        int[] ret = new int[priorityQueue.size()];
        while (!priorityQueue.isEmpty())
            for (int i = 0; i < priorityQueue.size(); i++)
                ret[i] = priorityQueue.poll().e;
        return ret;
    }

    private static void printList(List<Integer> nums) {
        for (Integer num : nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
//        int[] nums = {1};
//        int k = 1;
        printList((new Solution()).topKFrequent(nums, k));

    }
}
