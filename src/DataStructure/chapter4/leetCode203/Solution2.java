package DataStructure.chapter4.leetCode203;

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
 * 考虑：
 * 一、要删除的节点在第一个节点
 * 1.传入的链表第一个节点为空值
 * 2.找到了第一个val的节点并删除了，如果原链表的第二个节点还是val相等呢？继续删除 循环
 * 3.链表的所有节点都是要删除的节点，经过上述1、2两步后链表成了空，那么怎么处理？返null
 * 二、要删除的节点在中间位置
 * 4.经过一、的各个步骤，运行到这即头结点都不是空且val不满足条件，开始查看中间位置的节点
 * <p>
 * <p>
 * 不考虑空间开销（LeetCode网页编译器）、加入虚拟头结点
 * 好处？
 * 1.加入虚拟头结点不用考虑传入的链表为空链表情况
 *
 * @author Damon
 * @create 2020-10-19 20:56
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        //定义虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        //1. 2.
        while (head.val == val)
            head = head.next;
        //3.
        if (head == null)
            return null;
        //4.
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return head;
    }

}
