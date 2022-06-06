import java.util.*;

public class Leetcode_501 {
    public static void main(String[] args) {

    }


    public int[] findMode(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        int count = 0;
        int maxCount = 0;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (pre == null || cur.val != pre.val) {
                    count = 1;
                } else {
                    count++;
                }
                if (count > maxCount) {
                    maxCount = count;
                    res.clear();
                    res.add(cur.val);
                } else if (count == maxCount) {
                    res.add(cur.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
