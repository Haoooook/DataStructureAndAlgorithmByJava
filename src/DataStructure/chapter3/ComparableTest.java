package DataStructure.chapter3;

import DataStructure.chapter2.*;
import org.junit.Test;

import java.util.Random;

/**
 * 比较链表栈和数组栈
 * 比较数组队列、循环队列、链表队列
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

    /**
     * 比较链表栈和数组栈
     */
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

    public double runQueueTime(Queue<Integer> queue, int count) {
        //返回纳秒，1s = 1000 ms = 1000 000 μs = 1000 000 000 ns
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    /**
     * 比较数组队列、循环队列、链表队列
     */
    @Test
    public void testQueue() {
        int count = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        double t0 = runQueueTime(arrayQueue, count);
        double t1 = runQueueTime(loopQueue, count);
        double t2 = runQueueTime(linkedListQueue, count);

        System.out.println("ArrayQueue, run time: " + t0 + "s");
        System.out.println("LoopQueue, run time: " + t1 + "s");
        System.out.println("LinkedListQueue, run time: " + t2 + "s");

        /*
        10w个数据测试结果：
            ArrayQueue, run time: 2.918166625s
            LoopQueue, run time: 0.009857429s
            LinkedListQueue, run time: 0.008649389s
         */
    }
}
