package DataStructure.Chapter3;

/**
 * 链表
 * 基本的动态结构
 * 优点：无需处理容量的问题（即增、删、插入快）
 * 缺点：丧失随机方问得能力
 * <p>
 * 数组：最大优点访问速度快。
 *
 * @author Damon
 * @create 2020-09-17 14:50
 */
public class LinkedList<E> {

    //设计私有属性的节点类,不需要告诉用户节点类的细节
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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //在链表头添加元素e
    public void addFirst(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        //等价于以上三行
//        head = new Node(e, head);
//        size++;
        add(0, e);
    }

    //在链表中间插入元素
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("add() failed,Illegal index!");
        //设置虚拟的头节点，dummyHead 永远是第一个头节点，但一直是null不直接使用存储数据
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

}
