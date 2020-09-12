package DataStructure.chapter2;

import org.junit.Test;

/**
 * @author Damon
 * @create 2020-09-12 22:44
 */
public class QueueTest {
    @Test
    public void TestArrayQueue() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 15; i++) {
            queue.enqueue(2 * i + 1);
            System.out.println(queue);

            if (i % 3 == 1) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
