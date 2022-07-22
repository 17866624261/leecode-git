public class Leetcode_213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        // 区分不包含尾和不包含头两种情况，然后比较最大的就是所要求的的结果
        int result1 = robRange(nums, 0, nums.length - 2);
        int result2 = robRange(nums, 1, nums.length - 1);
        return Math.max(result1, result2);
    }

    public int robRange(int[] nums, int start, int end) {
        if (end == start) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start + 1], dp[start]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
