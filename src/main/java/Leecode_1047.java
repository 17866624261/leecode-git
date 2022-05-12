import java.util.Stack;

public class Leecode_1047 {
    public static void main(String[] args) {
        String s = "abbbabaaa";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || !stack.peek().equals(ch)) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }
        String str = "";
        while (!stack.isEmpty()){
            str = stack.pop() + str;
        }
        return str;
    }
}
