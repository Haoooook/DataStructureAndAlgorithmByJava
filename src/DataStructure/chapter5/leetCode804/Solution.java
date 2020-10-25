package DataStructure.chapter5.leetCode804;


import DataStructure.chapter5.BST;
import DataStructure.chapter5.BST2;

/**
 * leetCode 804 唯一的摩斯密码
 *
 * @author Damon
 * @create 2020-10-25 14:07
 */
public class Solution {

    public int uniqueMorseRepresentations(String[] words) {

        String[] code = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        BST2<String> bst = new BST2<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(code[word.charAt(i) - 'a']);
            }
            bst.add(res.toString());
        }

        return bst.size();
    }

    public static void main(String[] args) {
//        String[] words = {"gin", "zen", "gig", "msg"};
        String[] words = {"dwg", "we", "skt", "jdg", "fpx", "rng"};

        System.out.println((new Solution().uniqueMorseRepresentations(words)));
    }
}
