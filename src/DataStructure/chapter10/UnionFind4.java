package DataStructure.chapter10;

/**
 * 第四版并查集
 * 基于rank的优化 优化树的层数 尽可能的层数不要太大
 * 底层是数组实现的子节点指向父节点的树结构 实现（Union Find）并查集
 * unionElements（p,q）  O(h)
 * isConnected（p,q)    O(h)
 *
 * @author Haoooook
 * @create 2020-12-07 22:10
 */
public class UnionFind4 implements UnionFind {
    private int[] parent;
    private int[] rank;       //rank[i] 表示以i为根的集合表示的树的层数

    public UnionFind4(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;      //初始化的时候每个元素是独立的一个集合，只有自己这一个元素
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

        //根据两个元素所在的树的rank不同判断合并的方向
        //rank低的合并到rank高的树上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[qRoot] < rank[pRoot]) {
            parent[qRoot] = pRoot;
        } else {//sz[qRoot] == sz[pRoot]
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
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
