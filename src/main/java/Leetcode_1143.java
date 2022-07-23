public class Leetcode_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        // dp[i][j]表示以text1[i-1]和text2[j-1]结尾的最长子序列长度
        int[][] dp = new int[t1.length + 1][t2.length + 1];
        int result = -1;
        for (int i = 1; i <= t1.length; i++) {
            for (int j = 1; j <= t2.length; j++) {
                if (t1[i - 1] == t2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (dp[i][j] > result) result = dp[i][j];
            }
        }
        return result;
    }
}
