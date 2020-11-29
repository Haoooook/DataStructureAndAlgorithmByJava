package DataStructure.chapter10;

/**
 * 并查集
 * 解决问题：
 * 1.连接问题 如 网络中节点间的连接状态
 * 2.数学中集合类的实现
 * 3.路径问题
 *
 * 主要功能：
 * unionElements（p,q）
 * isConnected（p,q)
 *
 * @author Haoooook
 * @create 2020-11-29 21:28
 */
public interface UnionFind {
    int getSize();

    //不关心存储对象，以int index表示索引 映射 其对应其对象
    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
