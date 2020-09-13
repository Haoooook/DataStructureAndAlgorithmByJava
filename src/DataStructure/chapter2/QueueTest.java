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

    @Test
    public void TestLoopQueue(){
        LoopQueue<Integer> loopQueue = new LoopQueue<>(8);
        System.out.println("循环队列是否为空：" + loopQueue.isEmpty());
        System.out.println(loopQueue);
        System.out.println("实际创建的容量是 8 +1 =9，把我们需要浪费的一个空间封装起来，无需用户考虑");

        /*
        试图将错误类型的对象存储到一个对象数组时抛出的异常。例如，以下代码可生成一个 ArrayStoreException：
        Object x[] = new String[3];
        x[0] = new Integer(0);
         */
        for (int i = 0; i < 8; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }
    }
}
