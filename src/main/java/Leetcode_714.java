public class Leetcode_714 {
    public int maxProfit(int[] prices, int fee) {
        int result = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] >= minPrice && prices[i] <= minPrice + fee) {
                continue;
            }
            if (prices[i] > minPrice + fee) {
                result += prices[i] - fee - minPrice;
                minPrice = prices[i] - fee;
            }
        }
        String s = "";
        s.hashCode();
        return result;
    }

    public int maxProfit2(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] -= prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }
}
