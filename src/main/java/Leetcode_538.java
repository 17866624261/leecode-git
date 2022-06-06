public class Leetcode_538 {
    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    int pre;

    public void traversal(TreeNode cur) {
        if (cur == null) return;
        traversal(cur.right);
        cur.val += pre;
        pre = cur.val;
        traversal(cur.left);
    }
}
