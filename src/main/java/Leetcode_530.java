import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Leetcode_530 {
    public static void main(String[] args) {

    }

    TreeNode pre;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        int res = Integer.MAX_VALUE;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                if (pre != null) {
                    res = Math.min(res, cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return res;
    }
}
