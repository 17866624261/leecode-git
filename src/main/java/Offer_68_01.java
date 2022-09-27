public class Offer_68_01 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else {
                break;
            }
        }
        return root;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            root = lowestCommonAncestor2(root.right,p,q);
        } else if (root.val > p.val && root.val > q.val) {
            root = lowestCommonAncestor2(root.left,p,q);
        }
        return root;
    }
}
