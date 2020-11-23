package DataStructure.chapter6;

import java.util.ArrayList;

public class testBSTMapAndLinkedListMap {

    private static double testMap(Map<String, Integer> map, String filename) {

        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();

        if (FileOperation.readFile(filename, words)) {

            System.out.println("Total words: " + words.size());
            //把每个单词放入链表map中，第一次出现则初始value为1，此后每次重复出现则累加1。
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.println("Total different words : " + map.getSize());
            System.out.println("Frequency of pride : " + map.get("pride"));
            System.out.println("Frequency of prejudice : " + map.get("prejudice"));
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        String filename = "src/DataStructure/chapter6/pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s");

        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);
        System.out.println("Linked List Map: " + time2 + " s");

        //结果：

        //BSTMap
        //Total words: 125901
        //Total different words : 6530
        //Frequency of pride : 53
        //Frequency of prejudice : 11
        //BST Map: 0.146003175 s

        //LinkedListMap
        //Total words: 125901
        //Total different words : 6530
        //Frequency of pride : 53
        //Frequency of prejudice : 11
        //Linked List Map: 9.7944074 s

    }
}
