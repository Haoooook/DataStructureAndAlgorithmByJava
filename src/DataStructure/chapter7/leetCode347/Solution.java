package DataStructure.chapter7.leetCode347;

import DataStructure.chapter7.ArrayMaxHeap;

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
 *
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

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        ArrayMaxHeap<Freq> arrayMaxHeap = new ArrayMaxHeap<>();
        for (int key : map.keySet()) {
            if (arrayMaxHeap.size() < k)
                arrayMaxHeap.add(new Freq(key, map.get(key)));
            else if (map.get(key) > arrayMaxHeap.findMax().freq)
                arrayMaxHeap.replace(new Freq(key, map.get(key)));
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!arrayMaxHeap.isEmpty())
            res.add(arrayMaxHeap.extractMax().e);
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
