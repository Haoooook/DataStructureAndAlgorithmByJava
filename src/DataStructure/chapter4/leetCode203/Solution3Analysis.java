package DataStructure.chapter4.leetCode203;

/**
 * 把程序的执行过程打印出来
 *
 * @author Damon
 * @create 2020-10-19 20:56
 */
public class Solution3Analysis {
    public ListNode removeElements(ListNode head, int val, int depth) {
        String depthString = DepthString(depth);

        System.out.print(depthString);
        System.out.println(" Call: remove " + val + " in " + head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println(" Return : " + head);
            return head;
        }
        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println(" After remove " + val + " : " + res);


        ListNode ret;
        if (head.val == val)
            ret = res;
        else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println(" Return: " + ret);
        return ret;
    }

    private String DepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(num);
        System.out.println(head);

        ListNode res = new Solution3Analysis().removeElements(head, 6, 0);
        System.out.println(res);
    }
}
