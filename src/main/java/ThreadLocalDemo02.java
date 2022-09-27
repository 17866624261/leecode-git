import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyData{
    static ThreadLocal<Integer> threadLocalField= ThreadLocal.withInitial(()->0);
    public void add(){
        threadLocalField.set(1+threadLocalField.get());
    }
}

public class ThreadLocalDemo02 {
    public static void main(String[] args) {
        MyData myData = new MyData();
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.submit(()->{
                    try {
                        Integer before = myData.threadLocalField.get();
                        myData.add();
                        Integer after = myData.threadLocalField.get();
                        System.out.println(Thread.currentThread().getName()+"\t"+"beforeInt:"+before+"\t afterInt:"+after);
                    }finally {
                        myData.threadLocalField.remove();
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
