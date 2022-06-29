public class Leetcode_45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int curDistance = 0;
        int maxDistance = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= nums.length - 1) {
                count++;
                break;
            }
            if (i == curDistance) {
                count++;
                curDistance = maxDistance;
            }
        }
        return count;
    }
}
