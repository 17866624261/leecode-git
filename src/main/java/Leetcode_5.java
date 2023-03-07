public class Leetcode_5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            // 长度为1的字符串一定是回文
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArr = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = L + i - 1;
                if (j >= len) {
                    break;
                }

                if (charArr[i] != charArr[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        // 串长度为2以下，经过上面的判断一定是回文串
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
