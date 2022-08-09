import java.util.ArrayDeque;
import java.util.Deque;

public class Offer_09 {
    private Deque<Integer> stack;
    private Deque<Integer> reStack;
    public Offer_09() {
        stack = new ArrayDeque<>();
        reStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack.offerFirst(value);
    }

    public int deleteHead() {
        if (reStack.isEmpty()){
            if (stack.isEmpty()){
                return -1;
            }
            while (!stack.isEmpty()){
                reStack.offerFirst(stack.pollFirst());
            }
        }
        return reStack.pollFirst();
    }
}
