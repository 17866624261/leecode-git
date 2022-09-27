import jdk.jfr.internal.tool.Main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static final int threadCount = 500;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(threadCount);
        final Semaphore semaphore = new Semaphore(20,true);
        System.out.println(System.currentTimeMillis());
        for (int i = 1; i <= threadCount; i++) {
            final int threadnum = i;
            threadPool.execute(()->{
                try {
                    semaphore.acquire();
                    test(threadnum);
                    semaphore.release();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }
        System.out.println(System.currentTimeMillis());
        threadPool.shutdown();
        System.out.println("finish");
    }
    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("threadnum:"+threadnum);
        Thread.sleep(1000);
    }
}
