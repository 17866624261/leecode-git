import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
    private static final int threadCount = 200;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(30);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        long start = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            threadPool.execute(()->{
                try {
                    test(threadNum);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        threadPool.shutdown();
        long end = System.currentTimeMillis();
        System.out.println("finish time is "+(end-start));
    }
    public static void test(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadNum:"+threadNum);
        Thread.sleep(1000);
    }
}
