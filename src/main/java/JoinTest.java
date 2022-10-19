import java.util.concurrent.TimeUnit;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
//        t1.join();
        long endTime = System.currentTimeMillis();
        System.out.println("耗时："+(endTime - startTime)+"ms");
    }
}
