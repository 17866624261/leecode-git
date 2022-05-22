import java.util.*;

public class Leetcode_101 {
    public static void main(String[] args) {

    }

    /**
     * 递归法判断，分别判断左子树左节点和右子树右节点、左子树右节点和右子树左节点是不是相等。两边一起递归
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    private static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }
        return compare(left.left, right.right) && compare(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return true;
        }
        queue.offerFirst(root.left);
        queue.offerLast(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.pollFirst();
            TreeNode rightNode = queue.pollLast();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            queue.offerFirst(leftNode.left);
            queue.offerFirst(leftNode.right);
            queue.offerLast(rightNode.right);
            queue.offerLast(rightNode.left);
        }
        return true;
    }
}
