import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Leecode_150 {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(tokens[i])) {
                stack.push((-stack.pop()) + stack.pop());
            } else if ("*".equals(tokens[i])) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(tokens[i])) {
                int temp = stack.pop();
                stack.push(stack.pop() / temp);
            } else {
                // parseInt和valueOf方法都可以，一个是int基本数据类型，另一个是Integer对象。
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }
}
