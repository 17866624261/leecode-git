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
}
