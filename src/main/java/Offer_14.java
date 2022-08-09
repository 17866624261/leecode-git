import org.junit.Test;

public class Offer_14 {
    @Test
    public void testCutting(){
        System.out.println(cuttingRope(3));
    }

    public int cuttingRope(int n) {
        // dp[i]表示绳子长度为i的时候的最大乘积是多少
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                // 必须包含j<=i的情况，因为后面的值可能包含当前值不剪的情况
                dp[i] = Math.max(dp[i], dp[i - j] * j);
            }
        }
        for (int i = 1; i < n; i++) {
            dp[n] = Math.max(dp[n],dp[n-i]*i);
        }
        return dp[n];
    }
}
