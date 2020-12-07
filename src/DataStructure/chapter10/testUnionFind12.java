package DataStructure.chapter10;

import java.util.Random;

/**
 * 比较各版本并查集性能
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
        int size = 100000;
        int m = 100000;

        UnionFind1 uf1 = new UnionFind1(size);
        System.out.println("UnionFind1 : " + testUnionFind(uf1, m) + "s");

        UnionFind2 uf2 = new UnionFind2(size);
        System.out.println("UnionFind2 : " + testUnionFind(uf2, m) + "s");

        UnionFind3 uf3 = new UnionFind3(size);
        System.out.println("UnionFind3 : " + testUnionFind(uf3, m) + "s");

        UnionFind4 uf4 = new UnionFind4(size);
        System.out.println("UnionFind4 : " + testUnionFind(uf4, m) + "s");

        UnionFind5 uf5 = new UnionFind5(size);
        System.out.println("UnionFind5 : " + testUnionFind(uf5, m) + "s");

        UnionFind6 uf6 = new UnionFind6(size);
        System.out.println("UnionFind6 : " + testUnionFind(uf6, m) + "s");
    }
}
