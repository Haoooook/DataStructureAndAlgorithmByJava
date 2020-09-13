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
    public void TestLoopQueue() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>(8);

        System.out.println("\n============测试一般操作============");
        System.out.println("循环队列是否为空：" + loopQueue.isEmpty());
        System.out.println(loopQueue);
        System.out.println("实际创建的容量是 8 +1 =9，把我们需要浪费的一个空间封装起来，无需用户考虑");
        loopQueue.enqueue(-7);
        loopQueue.enqueue(10);
        System.out.println("队首元素：" + loopQueue.getFront());
        System.out.println(loopQueue);

        System.out.println("\n============测试添加5个元素============");
        /*
        试图将错误类型的对象存储到一个对象数组时抛出的异常。例如，以下代码可生成一个 ArrayStoreException：
        Object x[] = new String[3];
        x[0] = new Integer(0);

        原因：import org.omg.CORBA.Object; 莫名其妙导入这个玩意。。。好气
         */
        for (int i = 0; i < 5; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }

        System.out.println("\n============继续加入5个元素测试是否自动扩容============");
        for (int j = 0; j < 5; j++) {
            loopQueue.enqueue(j * 2 + 1);
            System.out.println(loopQueue);
        }

        System.out.println("\n============测试出队9个元素是否自动减容============");
        for (int k = 0; k < 9; k++) {
            loopQueue.dequeue();
            System.out.println(loopQueue);
        }
    }
}
