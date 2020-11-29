package DataStructure.chapter10;

import java.util.Random;

/**
 * 测试两个版本的并查集性能
 *
 * @author Haoooook
 * @create 2020-11-29 22:48
 */
public class testUnionFind12 {

    private static double testUnionFind(UnionFind uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int size = 10000;
        int m = 10000;

        UnionFind1 uf1 = new UnionFind1(size);
        System.out.println("UnionFind1 : " + testUnionFind(uf1, m) + "s");

        UnionFind2 uf2 = new UnionFind2(size);
        System.out.println("UnionFind2 : " + testUnionFind(uf2, m) + "s");
    }
}
//   size = 10 000  m = 10 000
//      UnionFind1 : 0.055922888s
//      UnionFind2 : 0.001436012s

//   size = 100 000  m = 100 000
//      UnionFind1 : 4.286534832s
//      UnionFind2 : 0.012038394s

//   size = 500 000  m = 500 000
//      UnionFind1 : 107.631479669s
//      UnionFind2 : 0.03661827s