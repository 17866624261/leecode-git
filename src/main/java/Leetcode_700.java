import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_700 {
    public static void main(String[] args) {

    }

    // 层序遍历
    public TreeNode searchBST(TreeNode root, int val) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return null;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == val) {
                return node;
            } else if (node.val < val && node.right != null) {
                queue.offer(node.right);
            } else if (node.val > val && node.left != null) {
                queue.offer(node.left);
            }
        }
        return null;
    }

    // 深度优先遍历
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.val == val) {
                return node;
            } else if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }
}
