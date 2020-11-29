package DataStructure.chapter10;

/**
 * 并查集
 * 解决问题：
 * 1.连接问题 如 网络中节点间的连接状态
 * 2.数学中集合类的实现
 * 3.路径问题
 *
 * 主要功能：
 * Union（p,q）
 * isConnected（p,q)
 *
 * @author Haoooook
 * @create 2020-11-29 21:28
 */
public interface UnionFind {
    void getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
