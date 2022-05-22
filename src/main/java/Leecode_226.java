import java.util.*;

public class Leecode_226 {
    public static void main(String[] args) {

    }

    // 层序遍历法
    public static TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode res = root;
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                TreeNode temp = new TreeNode();
                temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
        }
        return res;
    }
    
}
