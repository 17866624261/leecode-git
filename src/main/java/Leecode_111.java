import java.util.ArrayDeque;
import java.util.Deque;

public class Leecode_111 {
    public static void main(String[] args) {

    }

    public static int minDepth(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int deep = 0;
        if (root == null) {
            return deep;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            deep++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left == null && node.right == null) {
                    return deep;
                }
            }
        }
        return deep;
    }
}
