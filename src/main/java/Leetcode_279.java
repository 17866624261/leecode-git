public class Leetcode_279 {
    public int numSquares(int n) {
        // dp[i]表示和为i的完全平方数最小数量
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i*i; j <= n; j++) {
                if (dp[j-i*i] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
                }
            }
        }
        return dp[n];
    }
}
