package DataStructure.chapter2;

import org.junit.Test;

import java.util.Random;

/**
 * O(n)和O(1)两个时间复杂度的直观比较
 *
 * @author Damon
 * @create 2020-09-13 18:20
 */
public class ComparableTest {

    public double runQueueTime(Queue<Integer> q, int count) {
        //返回纳秒，1s = 1000 ms = 1000 000 μs = 1000 000 000 ns
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void testQueue() {
        int count = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();

        double t0 = runQueueTime(arrayQueue, count);
        double t1 = runQueueTime(loopQueue, count);
        System.out.println("ArrayQueue, run time: " + t0 + "s");
        System.out.println("LoopQueue, run time: " + t1 + "s");
        /*
        比较O(n)和O(1)两个时间复杂度的直观比较
        百万级数据：
            ArrayQueue, run time: 3.062930395s
            LoopQueue, run time: 0.010347751s

            ArrayQueue  dequeue()   O(n)
            LoopQueue   dequeue()   O(1)

         */
    }

}
