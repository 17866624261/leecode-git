import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

public class VolatileSeeDemo {
    volatile static boolean flag = true;
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t--------come in");
            while (flag){

            }
            System.out.println(Thread.currentThread().getName()+"\t -----flag被设置为false，线程结束");
        },"t1").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        flag = false;
        System.out.println(Thread.currentThread().getName()+"\t 修改完成flag:"+flag);
    }
}
