public class Leetcode_647 {
    // 动态规划解法
    public int countSubstrings(String s) {
        int result = 0;
        // dp[i][j]表示区间范围是[i,j]的子串是不是回文字符串
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        for (int i = s.length() - 1; i >=0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        result++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        result++;
                        dp[i][j] = true;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return result;
    }
}
