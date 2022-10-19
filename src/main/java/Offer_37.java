import java.util.*;

public class Offer_37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            // 把null节点也加入进来，如果为null则直接在结果中加上null
            if (node != null) {
                res.append(String.valueOf(node.val) + ",");
                queue.offerLast(node.left);
                queue.offerLast(node.right);
            } else {
                res.append("null,");
            }
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.valueOf(vals[i]));
                queue.offerLast(node.left);
            }
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.valueOf(vals[i]));
                queue.offerLast(node.right);
            }
            i++;
        }
        return root;
    }
}
