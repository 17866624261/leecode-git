import java.io.FileNotFoundException;
import java.util.Scanner;

public class LittleMouse {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long max = 0;
        int[][] dp = new int[n][n];
        dp[0][0] = in.nextInt();
        int flag =0;
        for (int i = 1; i < n; i++) {
            if (i != n-1) {
                for (int j = flag; j <= i; j++) {
                    int num = in.nextInt();
                    if (j == 0)
                        dp[i][j] = dp[i - 1][j] + num;
                    else
                        dp[i][j] = Math.max(dp[i + 1][j - 1], dp[i][j]) + num;
                    max = Math.max(dp[i][j], max);
                    flag = j;
                }
            }else{
                max += dp[i][flag];
            }
        }
        System.out.println(max);
    }

}
