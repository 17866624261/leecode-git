import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_572 {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null && subRoot != null) {
            return false;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.val == subRoot.val) {
                    if (isSameTree(node, subRoot)) return true;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return false;
    }

    public boolean isSameTree(TreeNode left, TreeNode right) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (left != null) deque.offerFirst(left);
        if (right != null) deque.offerLast(right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.left);
            deque.offerLast(rightNode.right);
        }
        return true;
    }
}
