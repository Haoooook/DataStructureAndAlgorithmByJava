package DataStructure.chapter3;

import DataStructure.chapter2.*;
import org.junit.Test;

import java.util.Random;

/**
 * 比较链表栈和数组栈
 *
 * @author Damon
 * @create 2020-09-24 10:52
 */
public class ComparableTest {

    public double runStackTime(Stack<Integer> stack, int count) {
        //返回纳秒，1s = 1000 ms = 1000 000 μs = 1000 000 000 ns
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void testStack() {
        int count = 100000;
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        double t0 = runStackTime(arrayStack, count);
        double t1 = runStackTime(linkedListStack, count);
        System.out.println("ArrayStack, run time: " + t0 + "s");
        System.out.println("LinkedListStack, run time: " + t1 + "s");

        /*
        10w个数据的结果：
            ArrayStack, run time: 0.0236697s
            LinkedListStack, run time: 0.0085736s
         */
    }

}
