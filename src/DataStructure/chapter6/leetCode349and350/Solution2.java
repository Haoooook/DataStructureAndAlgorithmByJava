package DataStructure.chapter6.leetCode349and350;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * <p>
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * <p>
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比,ums2小很多，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 使用treemap key存储值，value存储频次即key出现的次数
 *
 * @author Damon
 * @create 2020-11-07 21:22
 */
public class Solution2 {

    public int[] intersection(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int temp : nums1) {
            if (!treeMap.containsKey(temp))
                treeMap.put(temp, 1);
            else
                treeMap.put(temp, treeMap.get(temp) + 1);
        }

        for (int num : nums2) {
            if (treeMap.containsKey(num)) {
                arrayList.add(num);
                treeMap.put(num, treeMap.get(num) - 1);
                if (treeMap.get(num) == 0)
                    treeMap.remove(num);
            }
        }

        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }

}
