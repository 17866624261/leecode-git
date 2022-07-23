public class Leetcode_718 {
    public int findLength(int[] nums1, int[] nums2) {
        // dp[i][j]表示以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int result = -1;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > result) result = dp[i][j];
            }
        }
        return result;
    }
}
