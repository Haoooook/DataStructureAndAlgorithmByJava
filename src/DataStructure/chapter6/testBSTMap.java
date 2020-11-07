package DataStructure.chapter6;

import java.util.ArrayList;

/**
 * 基于BST实现Map
 *
 * @author Damon
 * @create 2020-11-07 17:19
 */
public class testBSTMap {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile(
                "/Users/damon/IDEA Project/DataStructureAndAlgorithmByJava/src/DataStructure/chapter6/pride-and-prejudice.txt", words1)) {

            System.out.println("Total words: " + words1.size());
            //把每个单词放入链表map中，第一次出现则初始value为1，此后每次重复出现则累加1。
            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words1) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.println("Total different words : " + map.getSize());
            System.out.println("Frequency of pride : " + map.get("pride"));
            System.out.println("Frequency of prejudice : " + map.get("prejudice"));
        }
    }

}
