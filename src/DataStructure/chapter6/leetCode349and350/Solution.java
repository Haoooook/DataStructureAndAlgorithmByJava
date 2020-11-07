package DataStructure.chapter6.leetCode349and350;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 题：给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author Damon
 * @create 2020-11-07 21:22
 */
public class Solution {

    public static int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int temp : nums1)
            treeSet.add(temp);
        for (int temp : nums2) {
            if (treeSet.contains(temp)) {
                arrayList.add(temp);
                treeSet.remove(temp);
            }

        }
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }

}
