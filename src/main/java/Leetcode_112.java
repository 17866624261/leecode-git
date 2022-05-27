import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_112 {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> sumStack = new ArrayDeque<>();
        int sum = 0;
        if (root == null) {
            return false;
        }
        stack.push(root);
        sumStack.push(root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int cur = sumStack.pop();
            if (node.left == null && node.right == null && cur == targetSum) {
                return true;
            }
            if (node.right != null){
                stack.push(node.right);
                sumStack.push(cur+node.right.val);
            }
            if (node.left != null){
                stack.push(node.left);
                sumStack.push(cur+node.left.val);
            }
        }
        return false;
    }
}
