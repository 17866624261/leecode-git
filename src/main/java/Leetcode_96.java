import java.util.HashSet;

public class Leetcode_96 {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("abc");
        set.add("abc");
        set.add("cde");
        System.out.println(set.size());
        set.remove("abc");
        System.out.println(set.size());
        System.out.println(set);
    }
    public int numTrees(int n) {
        // dp[i]表示从1到i为节点组成的二叉搜索树的个数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            // 求从1到i分别为头节点的二叉搜索树的个数求和
            for (int j = 1; j <= i; j++) {
                // 表示以j为头节点的左子树节点数量*以j为头节点的右子树节点数量
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];

    }
}
