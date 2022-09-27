import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class Match_0902 {
    Deque<Integer> deque = new ArrayDeque();
    public static void main(String[] args) {
        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
        integerThreadLocal.remove();
    }
}
class Pusher implements Runnable{
    public static boolean setValue(Integer value,BlockQueueImpl queue){
        if (queue.add(value))
            return true;
        else
            return false;
    }

    @Override
    public void run() {
//        Pusher.setValue();
    }
}
class Consumer{
    public Integer getValue(BlockQueueImpl queue) throws InterruptedException {
        Integer res = queue.get();
        return res;
    }
}
class BlockQueueImpl{
    Deque<Integer> deque = new ArrayDeque();
    public Integer get() throws InterruptedException {
        boolean flag = false;
        while (!flag){
            if (deque.isEmpty()){
                wait();
            }else {
                notifyAll();
                return deque.pollLast();
            }
        }
        return null;
    }
    public boolean add(Integer value){
        if (deque.offerFirst(value))
            return true;
        else
            return false;
    }
}
