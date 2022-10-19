public class Leetcode_70 {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        // dp[i]表示到第i层楼梯有i种方式
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public int climbStairs2(int n, int m) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i >= j) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[n];
    }

    public int climbStairs3(int n) {
        if (n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
