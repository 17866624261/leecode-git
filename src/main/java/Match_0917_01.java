import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadFactory;

public class Match_0917_01 {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        stack.push(nums[0]);
        int count = 0;
        int i = 1;
        while (!stack.isEmpty() && i < n){
            if ((stack.peek() + nums[i]) % 10 == 0){
                stack.pop();
                count+=2;
            }else {
                stack.push(nums[i]);
            }
            i++;
        }
        System.out.println(count);
    }
}
