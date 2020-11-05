package DataStructure.chapter6;

/**
 * 用链表实现映射Map
 *
 * @author Damon
 * @create 2020-11-05 22:25
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    //定义链表的节点
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {

            return key.toString() + " : " + value.toString();
        }
    }

    //创建底层需要的虚拟头节点dummyHead
    private Node dummyHead;
    private int size;

    public LinkedListMap() {

        dummyHead = new Node();
        size = 0;
    }

    /**
     * 向链表的头添加  如：链表1-2-3-null  添加5就是 5-1-2-3-null
     *
     * @param key
     * @param value
     */
    @Override
    public void add(K key, V value) {

        Node getNode = getNode(key);
        if (getNode == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            getNode.value = value;
            System.out.println(key + " 存在，已经覆盖value值！");
        }

    }

    @Override
    public V remove(K key) {
        //找到key所在的节点 的前一个节点
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.key.equals(key))
                break;
            prev=prev.next;
        }
        //找到了目标节点 的前一个节点prev，
        //那么把目标节点传给一个临时值，再把目标节点的next值（即排在后面的链表位置）传给prev的next
        //最后清空目标节点的next，
        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            prev.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {

        return getNode(key) != null;
    }

    private Node getNode(K key) {

        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public V get(K key) {

        Node getNode = getNode(key);
        return getNode == null ? null : getNode.value;
    }

    @Override
    public void set(K key, V newValue) {

        Node getNode = getNode(key);
        if (getNode == null)
            throw new IllegalArgumentException(key + " doesn't exist! ");

        getNode.value = newValue;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
