import java.util.concurrent.*;

public class CyclicBarrierExample {
    private static final int threadCount = 500;
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            threadPool.execute(()->{
                try {
                    test(threadNum);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }catch (BrokenBarrierException e){
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }
    public static void test(int threadNum) throws InterruptedException,BrokenBarrierException{
        System.out.println("threadNum: "+threadNum+" is ready");
        try {
            cyclicBarrier.await(60, TimeUnit.SECONDS);
        }catch (Exception e){
            System.out.println("Exception");
        }
        System.out.println("threadNUm:"+threadNum+" is finished");
    }
}
