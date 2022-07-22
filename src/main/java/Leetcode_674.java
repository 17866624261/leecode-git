public class Leetcode_674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            if (result < dp[i]) result = dp[i];
        }
        new Thread();
        return result;
    }
}
