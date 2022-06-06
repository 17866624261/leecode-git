import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_235 {
    public static void main(String[] args) {

    }

    // 二叉树递归法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null) return right;
        return left;
    }

    // 二叉搜索树递归法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestor2(root.left, p, q);
            if (left != null) return left;
        }
        if (root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestor2(root.right, p, q);
            if (right != null) return right;
        }
        return root;
    }

    // 迭代法
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {

        while (true) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
    }
}
