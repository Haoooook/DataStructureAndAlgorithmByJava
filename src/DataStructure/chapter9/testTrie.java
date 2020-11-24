package DataStructure.chapter9;


import DataStructure.chapter6.BSTSet;
import DataStructure.chapter6.FileOperation;
import DataStructure.chapter6.Set;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author Haoooook
 * @create 2020-11-23 22:55
 */
public class testTrie {
    public static void main(String[] args) {

        String filename = "pride-and-prejudice.txt";

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("src/DataStructure/chapter9/pride-and-prejudice.txt", words)) {
            long startTime = System.nanoTime();

            DataStructure.chapter6.BSTSet<String> set = new BSTSet<>();

            for (String word : words)
                set.add(word);

            for (String word : words)
                set.contains(word);

            long endTime = System.nanoTime();

            double time1 = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + set.getSize());
            System.out.println("BST Set: " + time1 + " s");

            System.out.println();

            long startTime2 = System.nanoTime();

            Trie trie = new Trie();
            for (String word : words)
                trie.recursionAdd(word);

            for (String word : words)
                trie.contains(word);

            long endTime2 = System.nanoTime();
            double time2 = (endTime2 - startTime2) / 1000000000.0;
            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie : " + time2 + " s");

        }

    }
}
