public class Leetcode_343 {
    public int integerBreak(int n) {
        // dp[i]表示拆分i的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                // j从1到i的dp[i]、j*(i-j)、以及j*dp[i-j]取最大值
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
