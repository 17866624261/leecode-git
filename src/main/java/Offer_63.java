public class Offer_63 {
    public int maxProfit(int[] prices) {
        // dp[i][0]表示第i天手持股票，dp[i][1]表示第i天不持股票的最大收益
        if (prices.length == 0 || prices == null) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] + prices[i],dp[i-1][1]);
        }
        return dp[prices.length - 1][1];
    }
}
