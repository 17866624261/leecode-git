import java.util.ArrayDeque;
import java.util.Deque;

public class Offer_59_2 {
    private Deque<Integer> deque;
    private Deque<Integer> queue;
    public Offer_59_2() {
        this.deque = new ArrayDeque<>();
        this.queue = new ArrayDeque<>();
    }

    public int max_value() {
        if (deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value){
            deque.removeLast();
        }
        deque.offerLast(value);
        queue.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()){
            return -1;
        }
        if (max_value() == queue.peekFirst()){
            deque.removeFirst();
        }
        return queue.pollFirst();
    }
}
