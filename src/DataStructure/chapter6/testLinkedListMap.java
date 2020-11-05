package DataStructure.chapter6;

import java.util.ArrayList;

/**
 * 测试链表实现的映射 map
 * 词频统计 每个单词出现的次数
 *
 * @author Damon
 * @create 2020-11-05 23:24
 */
public class testLinkedListMap {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile(
                "/Users/damon/IDEA Project/DataStructureAndAlgorithmByJava/src/DataStructure/chapter6/pride-and-prejudice.txt", words1)) {

            System.out.println("Total words: " + words1.size());
            //把每个单词放入链表map中，第一次出现则初始value为1，此后每次重复出现则累加1。
            LinkedListMap<String, Integer> map = new LinkedListMap<>();
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
