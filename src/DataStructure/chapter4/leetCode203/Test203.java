package DataStructure.chapter4.leetCode203;

/**
 * 创建测试用例，测试Solution结果
 *
 * @author Damon
 * @create 2020-10-19 21:31
 */
public class Test203 {
    public static void main(String[] args) {
//        int[] num = {-1,89,779,91,2,13,56,-1};
        int[] num = {1,2,2,2,2,2,2,2,2,1,2};
        ListNode head = new ListNode(num);
        System.out.println(head);

        ListNode res = new Solution2().removeElements(head,2);
        System.out.println(res);
    }

}
