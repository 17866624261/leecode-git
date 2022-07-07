import org.junit.Test;

import java.util.Arrays;

public class Leetcode_518 {
    @Test
    public void testChange() {
        String s2 = new String("abcde");
        String s1 = "abcde";
        String s3 = "abcde";
        s1 = "123";
        System.out.println(s1);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);
    }

    public int change(int amount, int[] coins) {
        // dp[j]表示可凑出金额为j元的组合数为dp[j]个
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // 组合问题，没有value。
                dp[j] += dp[j - coins[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[amount];
    }
}
