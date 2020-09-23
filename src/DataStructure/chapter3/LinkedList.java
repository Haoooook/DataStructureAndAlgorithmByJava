package DataStructure.chapter3;

/**
 * 链表
 * 基本的动态结构
 * 优点：无需处理容量的问题（即增、删、插入快）
 * 缺点：丧失随机方问得能力
 *
 * 数组：最大优点访问速度快。
 *
 * 添加元素 O(n)
 * addLast(e)   O(n)
 * addFirst(e)  O(1)
 * add(index,e) O(n/2)=O(n)
 *
 * 删除元素 O(n)
 * removeFirst()  O(n)
 * removeLast()   O(1)
 * remove(index)  O(n/2)=O(n)
 *
 * 修改元素
 * set(index,e) O(n)
 * contains(e)  O(n)
 * get(index)   O(n)
 * getIndex(e)  O(n)
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

    //设置虚拟的头节点，dummyHead 永远是第一个头节点，但一直是null不直接使用存储数据相当于是浪费一个空间
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

    /**
     * 在链表的任意位置插入元素
     *
     * @param index 目标位置
     * @param e     目标元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("add() failed,Illegal index!");
        //prev相当于指针，指向目标节点的前一个节点，prev.next指向当前节点。
        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        //1.prev.next指向目标节点位置，在这个位置之前，prev之后要插入一个元素
        //2.那么前一个节点prev的next应该指向一个新插入的节点，这个节点存储目标数据e
        //3.存储好e后，新节点的next就该指向原prev的next指向的节点，即prev.next
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获得元素信息
     *
     * @param index 目标元素的索引
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get() failed,Illegal index!");
        //指针，指向当前节点。
        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++)
            cur = cur.next;

        return cur.e;
    }

    /**
     * 把元素修改成目标元素
     *
     * @param index 索引位置
     * @param e     目标元素
     */
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("get() failed,Illegal index!");

        Node cur = dummyHead.next;

        for (int i = 0; i < index; i++)
            cur = cur.next;

        cur.e = e;
    }

    /**
     * 是否包含目标元素e？
     *
     * @param e 目标元素
     * @return
     */
    public boolean contains(E e) {
//        1. 第一种遍历写法
//        Node cur = dummyHead.next;
//
//        for (int i = 0; i < size; i++) {
//            if (e.equals(cur.e))
//                return true;
//            cur = cur.next;
//        }
//        return false;
//        第二种遍历写法，第三种写法用size的for循环
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            if (e.equals(cur.e))
                return true;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        //第四种遍历写法
        while (cur != null) {
            res.append(cur + "--->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    /**
     * 删除任意位置的链表元素
     *
     * @param index 目标元素的索引位置
     * @return 被删除的元素值
     */
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("remove() failed,index is illegal!");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node returnNode = prev.next;
        prev.next = returnNode.next;
        returnNode.next = null;
        size--;
        return returnNode.e;
    }

    //删除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    //删除最后一个元素
    public E removeLast() {
        return remove(size);
    }

    /**
     * 获得目标元素的索引
     *
     * @param e 目标元素
     * @return 目标元素的索引
     */
    public int getIndex(E e) {
        if (contains(e) == false)
            throw new IllegalArgumentException("remove() failed,value is inExistent!");
        Node cur = dummyHead.next;
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (e.equals(cur.e))
                return index;

            cur = cur.next;
            index++;
        }
        return index;
    }

    /**
     * 删除目标元素
     *
     * @param e 目标元素
     * @return 被删除的目标元素
     */
    public E removeElement(E e) {
        if (contains(e) == false)
            throw new IllegalArgumentException("remove() failed,value is inexistent!");

        int index = getIndex(e);

        return remove(index);

    }

}
