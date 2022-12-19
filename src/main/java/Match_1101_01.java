import java.util.Deque;
import java.util.LinkedList;

public class Match_1101_01 {
    public int findBottomLeftValue(TreeNode root) {
        // write code here
        if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);
        int res = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res = queue.peekLast().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollLast();
                if (node.left != null) {
                    queue.offerFirst(node.left);
                }
                if (node.right != null) {
                    queue.offerFirst(node.right);
                }
            }
        }
        return res;
    }
}
