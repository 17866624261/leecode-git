public class Leetcode_53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > result) {
                result = sum;
            }
            if (sum <= 0) {
                sum = 0;
            }
        }
        return result;
    }

    // 动态规划做法
    public int maxSubArray2(int[] nums) {
        if (nums.length == 0) return 0;
        int result = nums[0];
        // 包括下标i之前的最大连续字序列值和为dp[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (dp[i] > result) result = dp[i];
        }
        return result;
    }
}
