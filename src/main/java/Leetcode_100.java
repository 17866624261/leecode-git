import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_100 {
    public static void main(String[] args) {

    }

    // 双端队列法
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> deque = new LinkedList<>();
        if (p != null) deque.offerFirst(p);
        if (q != null) deque.offerLast(q);
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
