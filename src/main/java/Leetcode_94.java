import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode_94 {
    // 递归遍历法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root, res);
        return res;
    }

    public void traverse(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        traverse(node.left, res);
        res.add(node.val);
        traverse(node.right, res);
    }

    // 迭代遍历法
    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                // 使用指针访问最低层的节点
                // 将访问的节点放进栈里
                stack.offerFirst(cur);
                cur = cur.left; // 左
            } else {
                cur = stack.pollFirst();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
