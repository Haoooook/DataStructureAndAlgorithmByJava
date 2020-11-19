package DataStructure.chapter8.LeetCode307;

import org.junit.Test;

/**
 * @author Haoooook
 * @create 2020-11-20 00:00
 */
public class testNumArray {

    @Test
    public void testNumArray() {
        int[] nums = {4, 0, -1, 99, 100, 21, 9, 17};
        NumArray2 numArray = new NumArray2(nums);

        System.out.println(numArray.sumRange(1, 3));

        numArray.update(2,-99);
        System.out.println(numArray.sumRange(1, 3));

    }

    @Test
    public void testNumArray2() {
        int[] nums = {4, 0, -1, 99, 100, 21, 9, 17};
        NumArray2 numArray2 = new NumArray2(nums);

        System.out.println(numArray2.sumRange(1, 3));

        numArray2.update(2,-99);
        System.out.println(numArray2.sumRange(1, 3));
    }

}
