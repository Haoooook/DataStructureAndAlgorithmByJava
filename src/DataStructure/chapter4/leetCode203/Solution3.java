package DataStructure.chapter4.leetCode203;

import DataStructure.chapter4.leetCode203.ListNode;

/**
 * 习题：
 * LeetCode #203
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * <p>
 * 递归实现
 * 拆分：
 * 1->【子节点】->null
 * 1-> 2->【子节点】->null
 * ...
 * 1->2->6->3->4->5->6->null
 * <p>
 * 每次拆分 检查val是否，
 * 如果符合那么直接把当前节点的下一个节点续给上一个节点的next，实现删除当前节点
 * 不符合那么直接返回当前节点
 *
 * @author Damon
 * @create 2020-10-19 20:56
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        //最基本问题：找到最后一个节点后怎么处理？
        if (head == null)
            return null;
        /*
        //res存储的是 头结点后面的子链表 这个子链表删除了符合要求的节点
        ListNode res = removeElements(head.next, val);
        //上面一步没包含头结点（此时的头结点应为每次拆分后的头结点），但是如果头结点就是要删除的节点呢？直接返res
        if (head.val == val)
            return res;
        else {
        //如果头结点不是要删除的节点，那么把子链表续给当前的这个头结点
            head.next = res;
            return head;
        }

         */
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

}
