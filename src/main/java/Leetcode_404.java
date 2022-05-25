import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_404 {
    public static void main(String[] args) {

    }

    // 层序遍历
    public int sumOfLeftLeaves(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int sum = 0;
        if (root == null) {
            return sum;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.left == null && node.left.right == null) {
                        sum += node.left.val;
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return sum;
    }

    // 深度优先遍历，先序遍历
    public int sumOfLeftLeaves2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        if (root == null) {
            return sum;
        }
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            if (node.right != null) {
                stack.offerLast(node.right);
            }
            if (node.left != null) {
                stack.offerLast(node.left);
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
            }
        }
        return sum;
    }
}
