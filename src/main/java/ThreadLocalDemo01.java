import java.lang.ref.WeakReference;
import java.util.Random;
import java.util.concurrent.TimeUnit;

class House{
    int saleCount = 0;
    public synchronized void saleHouse(){
        saleCount++;
    }
    ThreadLocal<Integer> saleValume = ThreadLocal.withInitial(() -> 0);
    public void saleHouseByLocal(){
        saleValume.set(1+saleValume.get());
    }
}

public class ThreadLocalDemo01 {
    public static void main(String[] args) {
        House house = new House();
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                int size = new Random().nextInt(5) + 1;
                try {
                    for (int j = 1; j <= size; j++) {
                        house.saleHouse();
                        house.saleHouseByLocal();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t"+"共计卖出："+house.saleValume.get());
                }finally {
                    house.saleValume.remove();
                }
            },String.valueOf(i)).start();
        }
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"\t"+"共计卖出多少套："+house.saleCount);
    }
}
