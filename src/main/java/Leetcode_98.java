import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_98 {
    public static void main(String[] args) {

    }

    TreeNode max;

    // 递归法
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        if (max != null && root.val <= max.val) {
            return false;
        }
        max = root;
        boolean right = isValidBST(root.right);
        return right;
    }

    // 迭代法
//    public boolean isValidBST2(TreeNode root) {
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        if (root == null)
//            return true;
//        stack.offer(root);
//        while (!stack.isEmpty()){
//
//        }
//    }
}
