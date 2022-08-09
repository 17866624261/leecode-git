import java.util.*;

public class Leetcode_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    public void traverse(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        traverse(node.left, res);
        traverse(node.right, res);
        res.add(node.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollFirst();
            res.add(node.val);
            if (node.left != null) stack.offerFirst(node.left);
            if (node.right != null) stack.offerFirst(node.right);
        }
        Collections.reverse(res);
        return res;
    }
}
