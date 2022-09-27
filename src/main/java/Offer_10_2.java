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
    public int numWays(int n) {
        if (n < 2){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
    public int numWays2(int n) {
        int n2 = 1,n1 = 1,sum;
        for (int i = 0; i < n; i++) {
            sum = (n1 + n2) % 1000000007;
            n2 = n1;
            n1 = sum;
        }
        return n1;
    }
}
