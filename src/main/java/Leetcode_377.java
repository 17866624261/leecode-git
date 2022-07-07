public class Leetcode_377 {
    public int combinationSum4(int[] nums, int target) {
        // dp[j]表示和为j的nums中组合个数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {// 遍历背包
            for (int j = 0; j < nums.length; j++) {// 遍历物品
                if (i >= nums[j]) {
                    // 小于则会出现负数
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
