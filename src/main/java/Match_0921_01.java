public class Match_0921_01 {
    public int maxSubArray(int[] nums) {
        // write code here
        if (nums.length == 1) {
            return nums[0];
        }
        int sumValue = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            sumValue = Math.max(sumValue, count);
            if (count <= 0) {
                count = 0;
            }
        }
        return sumValue;
    }
}
