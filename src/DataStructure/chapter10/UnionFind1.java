package DataStructure.chapter10;

/**
 * 第一版模拟实现
 * 数组实现（Quick Find）并查集
 * unionElements（p,q）  O(n)
 * isConnected（p,q)    O(1)
 *
 * @author Haoooook
 * @create 2020-11-29 22:01
 */
public class UnionFind1 implements UnionFind {
    //底层 数组
    private int id[];

    //初始化 底层为每个元素都是属于不同集合的对象
    public UnionFind1(int size) {
        id = new int[size];

        for (int i = 0; i < size; i++)
            id[i] = i;
    }

    //底层私有方法 通过索引找到对应的值
    private int find(int index) {
        if (index < 0 || index > id.length)
            throw new IllegalArgumentException("Index is out of bound !");
        return id[index];
    }

    @Override
    public int getSize() {
        return id.length;
    }

    //查看索引p 和 q 对应的元素是否同属一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //将索引p 和 q 对应的元素合并成一个集合 既已成一个集合则无需关心其值是谁
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId)
            return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId)
                id[i] = qId;
        }
    }
}
