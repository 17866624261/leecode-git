import java.util.Stack;

public class Leecode_20 {
    public static void main(String[] args) {
        String s = "(){}[]";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || !stack.pop().equals(ch)){
                        return false;
                    }
            }
        }
        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
}
