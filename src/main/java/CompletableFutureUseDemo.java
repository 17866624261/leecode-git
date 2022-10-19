import java.util.concurrent.*;

public class CompletableFutureUseDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        int res = 0;
        try {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "-----come in");
                int result = ThreadLocalRandom.current().nextInt(10);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行结果为：" + result);
//                if (result > 1){
//                    int i = 10/0;
//                }
                return result;
            }, threadPool).whenComplete((v, e) -> {
                if (e == null) {
                    System.out.println("计算完成，更新系统UpdateValue:" + v);
                }
            }).exceptionally(e -> {
                e.printStackTrace();
                System.out.println("异常情况：" + e.getCause() + "\t" + e.getMessage());
                return null;
            });

//            res = future.get();
            res = future.join();
            System.out.println("外部的res是：" + res);
            System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
