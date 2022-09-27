public class Offer_55_2 {
    public boolean isBalanced(TreeNode root) {
        return backTracking(root) != -1;
    }

    public int backTracking(TreeNode root) {
        if (root == null) return 0;
        int left = backTracking(root.left);
        if (left == -1) return -1;
        int right = backTracking(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
