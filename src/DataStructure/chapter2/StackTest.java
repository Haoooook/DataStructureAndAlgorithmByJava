package DataStructure.chapter2;

import org.junit.Test;

/**
 * 测试stack
 *
 * @author Damon
 * @create 2020-09-12 18:33
 */
public class StackTest {
    @Test
    public void TestArrayStack() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}
