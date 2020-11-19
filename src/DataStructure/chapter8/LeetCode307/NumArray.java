package DataStructure.chapter8.LeetCode307;

/**
 * 给定一个整数数组 nums，求出数组从索引i到j(i≤j) 范围内元素的总和，包含i, j两点。
 *
 * update(i, val) 函数可以通过将下标为i的数值更新为val，从而对数列进行修改。
 *
 * 示例:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 说明:
 *
 * 数组仅可以在update函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Haoooook
 * @create 2020-11-19 23:26
 */
public class NumArray {

    private int[] sum;
    private int[] newNums;

    public NumArray(int[] nums) {
        newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
    }

    public int sumRange(int i, int j) {//O(1)
        return sum[j + 1] - sum[i];
    }

    public void update(int i, int val) {//O(n)
        newNums[i] = val;
        sum = new int[newNums.length + 1];
        sum[0] = 0;
        for (int k = 1; k < sum.length; k++)
            sum[k] = sum[k - 1] + newNums[k - 1];
    }
}