
import com.google.common.base.Converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class TestMultiTh {
    public static void main(String[] args) throws InterruptedException {
        // n个大白，m个居民核酸检测，每个检测5m钟，问小区封闭的时间
//        LocalTime start = LocalTime.now().withNano(0);
//        System.out.println(start);
//        Thread.sleep(1000);
////        LocalTime end = LocalTime.now().withNano(0);
//        LocalDateTime of = LocalDateTime.of(2021, 1, 26, 12, 12, 12);
////        LocalDateTime.parse("2021-01-26 12:12:12");
//        ZonedDateTime zonedDateTime = ZonedDateTime.now();
//        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
//        System.out.println(zonedDateTime);

        int n = 5;
        int m = 10;
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                n,
                n,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(m),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
//        ExecutorService service = Executors.newFixedThreadPool(n);
//        final Semaphore semaphore = new Semaphore(n,true);
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(m);
        for (int i = 0; i < m; i++) {
//            executor.execute(new WorkerDabai(50L));
            executor.execute(()->{
                try {
//                    semaphore.acquire();
                    Thread.sleep(5000);
//                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        executor.shutdown();
//        while (!executor.isTerminated()){
//
//        }
        System.out.println("总共的处理时间是："+(end-start)+"mills");
    }
}

class WorkerDabai implements Runnable {
    private long sleepTime;

    public WorkerDabai(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
