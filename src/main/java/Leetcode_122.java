public class Leetcode_122 {
    public int maxProfit(int[] prices) {
        int sumIn = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                sumIn += prices[i + 1] - prices[i];
            }
        }
        return sumIn;
    }
}
