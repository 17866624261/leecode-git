import java.util.HashSet;

public class Match_0831_01 {
    public HashSet<Integer> set = new HashSet<>();
    public int getColor (TreeNode root) {
        if (root == null) return 0;
        recur(root);
        return set.size();
    }
    public void recur(TreeNode root){
        if (root == null) return;
        recur(root.left);
        set.add(root.val);
        recur(root.right);
    }
}
