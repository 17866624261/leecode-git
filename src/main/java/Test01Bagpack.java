public class Test01Bagpack {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagsize = 4;
        testweightbagproblem2(weight, value, bagsize);
    }

    public static void testweightbagproblem(int[] weight, int[] value, int bagsize) {
        int[][] dp = new int[weight.length][bagsize + 1];
        for (int j = 0; j <= bagsize; j++) {
            if (j >= weight[0]) {
                dp[0][j] = value[0];
            }
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= bagsize; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        //打印dp数组
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= bagsize; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void testweightbagproblem2(int[] weight, int[] value, int bagsize) {
        int[] dp = new int[bagsize + 1];
        for (int i = 0; i < weight.length; i++) {
            // 重量需要倒序遍历，因为dp的计算需要之前的数据，如果正序遍历就会导致多次重复计算前面的数据
            for (int j = bagsize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        System.out.println(dp[bagsize]);
    }
}
