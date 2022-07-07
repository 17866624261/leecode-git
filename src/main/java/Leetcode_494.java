import org.junit.Test;

public class Leetcode_494 {
    @Test
    public void testSum() {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays(nums, 3));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (Math.abs(target) > sum) return 0;
        // 如果是奇数的话没有办法得到结果
        if ((sum + target) % 2 == 1) return 0;
        int bagsize = (sum + target) / 2;
        // dp[j]表示填满j这么大容量的包，有dp[j]种方法。
        int[] dp = new int[bagsize + 1];
        // dp[0]如果是0的话循环完所有的结果都是0
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagsize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagsize];
    }
}
