package DataStructure.chapter6;

import java.util.ArrayList;

/**
 * @author Damon
 * @create 2020-10-28 20:39
 */
public class testBSTSet {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("/Users/damon/IDEA Project/DataStructureAndAlgorithmByJava/src/DataStructure/chapter6/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("/Users/damon/IDEA Project/DataStructureAndAlgorithmByJava/src/DataStructure/chapter6/a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for (String word : words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
