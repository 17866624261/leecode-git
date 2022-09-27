public class Match_0907_01_01 {
    public int maxScore (int energy, int[][] actions) {
        // write code here
        int weightLen = actions.length;
        int[][] dp = new int[weightLen+1][energy+1];
        for (int i = 0; i <= weightLen; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= weightLen; i++) {
            for (int j = 1; j <= energy; j++) {
                if (j < actions[i-1][0]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-actions[i-1][0]]+actions[i-1][1]);
                }
            }
        }
        return dp[weightLen][energy];
    }
}
