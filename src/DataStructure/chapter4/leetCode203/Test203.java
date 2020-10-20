package DataStructure.chapter4.leetCode203;

import org.junit.Test;

/**
 * 创建测试用例，测试Solution结果
 *
 * @author Damon
 * @create 2020-10-19 21:31
 */
public class Test203 {

    @Test
    public void testSolution() {
        int[] num = {-1, 89, 779, 91, 2, 13, 56, -1};
        ListNode head = new ListNode(num);
        System.out.println(head);

        ListNode res = new Solution().removeElements(head, 2);
        System.out.println(res);
    }

    @Test
    public void testSolution2() {
        int[] num = {-1, 89, 779, 91, 2, 13, 56, -1};
        ListNode head = new ListNode(num);
        System.out.println(head);

        ListNode res = new Solution2().removeElements(head, 2);
        System.out.println(res);
    }

    @Test
    public void testSolution3() {
        int[] num = {-1, 89, 779, -1, 2, 91, 2, 13, 56, -1};
        ListNode head = new ListNode(num);
        System.out.println(head);

        ListNode res = new Solution3().removeElements(head, -1);
        System.out.println(res);
    }

}
