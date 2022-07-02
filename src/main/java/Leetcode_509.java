public class Leetcode_509 {
    // 递归解法
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public int fib2(int n) {
        if (n <= 1) return n;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
