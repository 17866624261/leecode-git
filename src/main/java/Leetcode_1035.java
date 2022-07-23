import java.util.UUID;

public class Leetcode_1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // dp[i][j]表示
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int resule = -1;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (resule < dp[i][j]) {
                    resule = dp[i][j];
                }
            }
        }
        return resule;
    }
}
