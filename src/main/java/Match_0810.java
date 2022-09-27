import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Match_0810 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();

        int result = x.length();
        for (int j = 0; j < x.length(); j++) {

            if (x.charAt(j) == '(' || x.charAt(j) == ')') {
                stringBuilder.append(x.charAt(j));
            } else {

                int maxans = 0;
                String s = stringBuilder.toString();
                int[] dp = new int[s.length()];
                for (int i = 1; i < s.length(); i++) {
                    if (s.charAt(i) == ')') {
                        if (s.charAt(i - 1) == '(') {
                            dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                        } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                            dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                        }
                        maxans = Math.max(maxans, dp[i]);
                    }
                }
                result -= maxans;
                stringBuilder = new StringBuilder();
            }


        }

        if (stringBuilder.length() > 0) {
            int maxans = 0;
            String s = stringBuilder.toString();
            int[] dp = new int[s.length()];
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (s.charAt(i - 1) == '(') {
                        dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                    maxans = Math.max(maxans, dp[i]);
                }
            }
            result -= maxans;
        }

        System.out.println(result);


    }
}
