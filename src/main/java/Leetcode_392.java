public class Leetcode_392 {
    // 双指针做法
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.length() == 0) return true;
        int sIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(sIndex)) {
                sIndex++;
            }
            if (sIndex == s.length()) return true;
        }
        return false;
    }

    // 动态规划做法
    public boolean isSubsequence2(String s, String t) {
        // dp[i][j]表示以下标i-1为结尾的字符串s和以下标j-1为结尾的字符串t，相同子序列的长度为dp[i][j]
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        if (dp[s.length()][t.length()] == s.length()) return true;
        return false;
    }
}
