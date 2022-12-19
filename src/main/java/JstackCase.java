import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 有个导致CPU过高程序的demo，死循环
 */
public class JstackCase {

     private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {

        Task task1 = new Task();
        Task task2 = new Task();
        executorService.execute(task1);
        executorService.execute(task2);
    }

    public static Object lock = new Object();

    static class Task implements Runnable{

        public void run() {
            synchronized (lock){
                long sum = 0L;
                while (true){
                    sum += 1;
                }
            }
        }
    }
}
