public class Offer_28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true:recur(root.left,root.right);
    }
    boolean recur(TreeNode l,TreeNode r){
        if (l == null && r == null) return true;
        if (l == null || r == null || l.val != r.val) return false;
        return recur(l.right,r.left) && recur(l.left,r.right);
    }
}
