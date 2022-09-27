public class Offer_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        recur(root);
        return root;
    }

    void recur(TreeNode root) {
        if (root == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        recur(root.left);
        recur(root.right);
    }
}
