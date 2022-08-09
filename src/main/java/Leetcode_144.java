import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    public void traverse(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        res.add(node.val);
        traverse(node.left, res);
        traverse(node.right, res);
    }
    // 迭代遍历法
    public List<Integer> preorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        stack.offerFirst(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollFirst();
            res.add(node.val);
            if (node.right != null){
                stack.offerFirst(node.right);
            }
            if (node.left != null){
                stack.offerFirst(node.left);
            }
        }
        return res;
    }
}
