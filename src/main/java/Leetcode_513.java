import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_513 {
    public static void main(String[] args) {

    }

    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int cur = 0;
        if (root == null) {
            return cur;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    cur = node.val;
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return cur;
    }
}
