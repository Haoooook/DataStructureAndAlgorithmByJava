package DataStructure.chapter10;

/**
 * 第二版模拟实现
 * 底层是数组实现的子节点指向父节点的树结构 实现（Union Find）并查集
 * unionElements（p,q）  O(h)
 * isConnected（p,q)    O(h)
 *
 * @author Haoooook
 * @create 2020-11-29 22:01
 */
public class UnionFind2 implements UnionFind {
    //底层 数组
    private int parent[];

    //初始化 底层为每个元素都是属于不同集合的对象
    public UnionFind2(int size) {
        parent = new int[size];

        for (int i = 0; i < size; i++)
            parent[i] = i;
    }

    //底层私有方法 通过索引找到对应值的根节点
    //O(h) h为树的高度
    private int find(int index) {
        if (index < 0 || index > parent.length)
            throw new IllegalArgumentException("Index is out of bound !");

        while (index != parent[index])
            index = parent[index];
        return index;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    //查看索引p 和 q 对应的元素是否同属一个集合
    //O(h) h为树的高度
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //将索引p 和 q 对应的元素合并成一个集合，即找到p的根节点后 让p的根节点指向q的根节点完成合并
    //O(h) h为树的高度
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == pRoot)
            return;
        else
            parent[pRoot] = qRoot;
    }
}
