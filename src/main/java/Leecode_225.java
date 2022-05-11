import java.util.LinkedList;
import java.util.Queue;

public class Leecode_225 {
    Queue<Integer> queueIn;
    Queue<Integer> queueOut;

    public Leecode_225() {
        queueIn = new LinkedList<>();
        queueOut = new LinkedList<>();
    }

    public void push(int x) {
        queueOut.offer(x);
        while (!queueIn.isEmpty()){
            queueOut.offer(queueIn.poll());
        }

        queueIn = queueOut;
        queueOut.clear();
    }

    public int pop() {
        return queueIn.poll();
    }

    public int top() {
        return queueIn.peek();
    }

    public boolean empty() {
        return queueIn.isEmpty();
    }
}
