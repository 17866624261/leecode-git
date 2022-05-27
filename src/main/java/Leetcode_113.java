import java.util.*;

public class Leetcode_113 {
    List<List<Integer>> result;
    LinkedList<Integer> path;

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new LinkedList<>();
        path = new LinkedList<>();
        travesal(root, targetSum);
        return result;
    }

    public void travesal(TreeNode root, int count) {
        if (root == null) return;
        path.offer(root.val);
        count -= root.val;
        if (root.left == null && root.right == null && count == 0) {
            result.add(new LinkedList<>(path));
        }
        travesal(root.left, count);
        travesal(root.right, count);
        path.removeLast();
    }
}
