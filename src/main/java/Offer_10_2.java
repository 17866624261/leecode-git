import org.junit.Test;

public class Offer_10_2 {
    @Test
    public void testJump(){
        System.out.println(jumpFloor(2));
    }

    public int jumpFloor(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
