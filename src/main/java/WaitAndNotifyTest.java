import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class WaitAndNotifyTest {
    public static void main(String[] args) throws InterruptedException {
        BlockQueueTest blockQueueTest = new BlockQueueTest();
//        new ReentrantLock();
//        new CountDownLatch();
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
//        threadPool.submit()
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 100, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(100));
        int a = 1;
//        a++,a--,a+=1;
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                blockQueueTest.setCount("第" + i + "任务");
            }
        }).start();
        Thread add = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(blockQueueTest.getCount());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);

    }
}

class BlockQueueTest {
    Queue<String> queue = new LinkedList<>();

    public synchronized String getCount() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }

    public synchronized void setCount(String s) {
        this.queue.add(s);
        this.notifyAll();
    }
}
