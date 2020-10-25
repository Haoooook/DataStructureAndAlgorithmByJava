package DataStructure.chapter5;

import org.junit.Test;

/**
 * 测试
 *
 * @author Damon
 * @create 2020-10-25 13:41
 */
public class testDemo {

    @Test
    public void testBST() {
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < 8; i++) {
            bst.add(i * 2 - 1);
            System.out.println(bst);
        }
    }
}
