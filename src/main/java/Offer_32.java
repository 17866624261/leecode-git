import java.util.*;

public class Offer_32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offerFirst(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollLast();
            res.add(node.val);
            if (node.left != null) {
                queue.offerFirst(node.left);
            }
            if (node.right != null) {
                queue.offerFirst(node.right);
            }
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offerFirst(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.pollLast();
                path.add(node.val);
                if (node.left != null) queue.offerFirst(node.left);
                if (node.right != null) queue.offerFirst(node.right);
            }
            res.add(path);
        }
        return res;
    }
    public List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offerFirst(root);
        while (!queue.isEmpty()) {
            int length = queue.size();
            List<Integer> path = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.pollLast();
                path.add(node.val);
                if (node.left != null) queue.offerFirst(node.left);
                if (node.right != null) queue.offerFirst(node.right);
            }
            res.add(path);
        }
        for (int i = 1; i < res.size(); i=i+2) {
            Collections.reverse(res.get(i));
        }
        return res;
    }
}
