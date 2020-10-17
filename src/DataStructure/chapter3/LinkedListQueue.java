package DataStructure.chapter3;

import DataStructure.chapter2.Queue;

/**
 * 链表实现队列
 * 特点：添加元素是依次添加，删除元素时从头开始，即满足先进去的先删掉。
 * 由于按之前的链表结构只有next节点来确定下一个节点，没办法快速定位某个节点（不像数组可以索引定位位置）
 * 因此需要灵活改变一点此前的链表结构：1.去掉虚拟节点dummyHead（因为引入tail和head）2.定义队列的头、尾
 * <p>
 * 因为队列是先进去的先删除，为了满足删除这个操作的方便性（实现时间复杂度为O(1)）、添加元素的方便性（实现时间复杂度为O(1)）
 * 链表的末端的节点为队列的尾 tail
 * 链表的首端的节点尾队列的头 head
 * 至此实现了队列的特点也实现了这两个方法的时间复杂度为常数级
 *
 * @author Damon
 * @create 2020-10-10 14:48
 */
public class LinkedListQueue<E> implements Queue<E> {

    //基本的节点结构是不变的
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 入队操作：
     * 判断情况队列为空和不为空、维护size的变更；
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }

        size++;
    }

    /**
     * 出队 注意当链表队列只有一个元素是出队后判断问题
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("dequeue() failed, cannot dequeue from an empty queue");

        Node retNode = head;
        head = head.next;
        retNode.next = null;

        //如果链表只有一个元素，删除第一个元素后要判断
        if (head == null)
            tail = null;

        size--;

        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty");

        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue:head ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "--->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
