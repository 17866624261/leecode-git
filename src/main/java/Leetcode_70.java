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
}
