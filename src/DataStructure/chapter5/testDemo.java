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

    @Test
    public void testBST3(){
        BST3<Integer> bst = new BST3<>();
        int[] demo = {7,1,16,13,0,100,27,3,52};
        for(int num : demo)
            bst.add(num);

        bst.preOrder();
        System.out.println();
        System.out.println(bst);

        bst.inOrder();
        System.out.println();
        System.out.println(bst);


        bst.postOrder();
        System.out.println();
        System.out.println(bst);

    }

    @Test
    public void testBST3levelOrder(){
        BST3<Integer> bst = new BST3<>();
        int[] demo = {7,1,16,13,0,100,27,3,52};
        for(int num : demo)
            bst.add(num);
        bst.levelOrder();
        System.out.println();

        bst.preOrder();
        System.out.println();

    }

    @Test
    public void testBST4(){
        BST4<Integer> bst = new BST4<>();
        int[] demo = {7,1,16,13,0,100,27,3,52};
        for(int num : demo)
            bst.add(num);
        System.out.println(bst.maximum());
        System.out.println(bst.minimum());

    }
}
