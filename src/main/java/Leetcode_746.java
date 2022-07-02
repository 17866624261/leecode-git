public class Leetcode_746 {
    // 动态规划算法（自己想的）
    public int minCostClimbingStairs(int[] cost) {
        // cost[i]表示爬上第i层阶梯就需要消耗的体力值
        if (cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }
        if (cost.length == 2) {
            return cost[0] < cost[1] ? cost[0] : cost[1];
        }
        // 表示爬到第i层台阶需要支付的最低费用
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }

    // 动态规划优化后
    public int minCostClimbingStairs2(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) return cost[0];
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
