package DataStructure.chapter10;

/**
 * 第三版并查集
 * 基于size的优化 避免树的深度太大、甚至极端情况称为一个单链表
 * 底层是数组实现的子节点指向父节点的树结构 实现（Union Find）并查集
 * unionElements（p,q）  O(h)
 * isConnected（p,q)    O(h)
 *
 * @author Haoooook
 * @create 2020-12-07 22:10
 */
public class UnionFind3 implements UnionFind {
    private int[] parent;
    private int[] sz;       //sz[i] 表示以i为根的集合中元素的个数

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;      //初始化的时候每个元素是独立的一个集合，只有自己这一个元素
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(q) == find(p);
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == pRoot)
            return;

        //根据两个元素所在的树的元素个数不同判断合并的方向
        //元素个数少的合并到元素个数多的树上
        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {//sz[qRoot] <= sz[pRoot]
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

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
}
