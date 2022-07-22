public class Leetcode_337 {
    public int rob(TreeNode root) {
        // 递归加动态规划
        int[] dp = robAction1(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] robAction1(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);
        // 不偷当前节点
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}
