public class Leetcode_701 {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < val) {
                pre = cur;
                cur = cur.right;
            } else {
                pre = cur;
                cur = cur.left;
            }
        }
        TreeNode node = new TreeNode(val);
        if (val < pre.val) {
            pre.left = node;
        } else {
            pre.right = node;
        }
        return root;
    }
}
