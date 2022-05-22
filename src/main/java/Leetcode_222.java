import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_222 {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        int sum = 0;
        if (root == null) {
            return sum;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            sum += size;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return sum;
    }
}
