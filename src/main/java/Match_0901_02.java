import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Match_0901_02 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public int maxValue (TreeNode root) {
        // write code here
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        HashMap<TreeNode,TreeNode> map = new HashMap<>();
        HashMap<TreeNode,TreeNode> last = new HashMap<>();

        int max = root.val;
        ArrayList<Integer> x = new ArrayList<>();
        while (queue.size() > 0){
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; ++i) {
                TreeNode t = queue.remove();
                sum += t.val;
                if (t.left != null){
                    queue.add(t.left);
                    map.put(t.left,t);
                }
                if (t.right != null){
                    queue.add(t.right);
                    map.put(t.right,t);
                }
            }
            max = Math.max(max,sum);
            if (last.size() > 0){
                for (TreeNode treeNode : last.keySet()) {
                    max = Math.max(max,sum - treeNode.val + last.get(treeNode).val);
                    int l = x.get(x.size() - 1);
                    max = Math.max(max,l-last.get(treeNode).val + treeNode.val);
                }
            }
            x.add(sum);
            last.clear();
            last.putAll(map);
            map.clear();
        }
        return max;
    }
}

