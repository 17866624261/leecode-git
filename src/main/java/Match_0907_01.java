import org.junit.Test;

public class Match_0907_01 {
    @Test
    public void test(){
        int energy = 10;
        int[][] actions = new int[][]{{1,1},{2,3},{3,5},{5,10},{7,9},{8,10}};
        System.out.println(maxScore(energy,actions));
    }

    public int maxScore(int energy, int[][] actions) {
        int wlen = actions.length;
        int[][] dp = new int[wlen + 1][energy + 1];
        for (int i = 0; i <=wlen ; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= wlen; i++) {
            for (int j = 1; j <= energy; j++) {
                if (j < actions[i-1][0]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-actions[i-1][0]]+actions[i-1][1]);
                }
            }
        }
        return dp[wlen][energy];
    }
}
