public class Match_1020_04 {
    public int maxDamage(int k1, int k2, int d1, int d2, int t, int x) {
        int[][] dp = new int[t][3];
        for (int i = 0; i < t; i++) {
            dp[i][0] = Math.max(i - 1 >= 0 ? dp[i - 1][0] : 0, (i - k1 >= 0 ? dp[i - k1][0] : 0) + d1);
            dp[i][1] = Math.max(i - 1 >= 0 ? dp[i - 1][1] : 0, (i - k2 >= 0 ? dp[i - k2][1] : 0) + d2);
            dp[i][2] = Math.max(i - 1 >= 0 ? dp[i - 1][2] : 0, (i - k1 >= 0 ? dp[i - k1][0] : 0) + (i - k2 >= 0 ? dp[i - k2][1] : 0) + (d1 + d2) * (1 + x));
            if (dp[i][0] + dp[i][1] < dp[i][2]) {
                dp[i][0] = i - k1 >= 0 ? dp[i - k1][0] + d1 * (1 + x) : d1 * (1 + x);
                dp[i][1] = i - k2 >= 0 ? dp[i - k2][1] + d2 * (1 + x) : d2 * (1 + x);
            } else {
                dp[i][2] = dp[i][0] + dp[i][1];
            }
        }
        return dp[t - 1][2];
    }
}
