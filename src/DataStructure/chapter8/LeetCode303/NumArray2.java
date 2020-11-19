package DataStructure.chapter8.LeetCode303;

/**
 * 用数组解题：
 * sum[i] 表示nums[]的前i个元素之和的结果，sum[0]=0;
 * 那么n个nums[] 就需要sum[]有n+1个空间存储结果，其中index=0，sum[0]=0；
 * <p>
 * 注意点：sum[]的索引 是 nums[]索引的 加1关系
 *
 * @author Haoooook
 * @create 2020-11-19 22:15
 */
public class NumArray2 {

    private int[] sum;

    public NumArray2(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}