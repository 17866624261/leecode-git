import java.util.ArrayDeque;
import java.util.Deque;

public class Offer_30 {
    Deque<Integer> A,B;
    public Offer_30() {
        A = new ArrayDeque<>();
        B = new ArrayDeque<>();
    }

    public void push(int x) {
        A.push(x);
        if (B.isEmpty() || B.peek() >= x){
            B.push(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
