package DataStructure.chapter6.leetCode804;


import java.util.TreeSet;

/**
 * leetCode 804 唯一的摩斯密码
 *
 * 使用java常备类库 treeSet ---基于红黑树的实现
 * @author Damon
 * @create 2020-10-25 14:07
 */
public class Solution {

    public int uniqueMorseRepresentations(String[] words) {

        String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        TreeSet<String> treeSet = new TreeSet<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++)
                res.append(code[word.charAt(i) - 'a']);

            treeSet.add(res.toString());
        }

        return treeSet.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
//        String[] words = {"dwg", "we", "skt", "jdg", "fpx", "rng"};

        System.out.println((new Solution().uniqueMorseRepresentations(words)));
    }
}
