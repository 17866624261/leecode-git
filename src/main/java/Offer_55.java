public class Offer_55 {
    private int res = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public void backTracking(TreeNode node, int deep) {
        if (node == null) {
            if (res < deep) {
                res = deep;
            }
            return;
        }
        deep++;
        if (node.left != null) backTracking(node.left, deep);
        if (node.right != null) backTracking(node.right, deep);
    }
}
