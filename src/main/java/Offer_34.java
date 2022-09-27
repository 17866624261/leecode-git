import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer_34 {
    public List<List<Integer>> res = new ArrayList<>();
    public LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        backTracking(root,target,0);
        return res;
    }
    public void backTracking(TreeNode root, int target,int sum){
        if (root == null)
            return;
        path.add(root.val);
        sum += root.val;
        if (sum == target && root.left == null && root.right == null){
            res.add(new ArrayList<>(path));
        }
        backTracking(root.left,target,sum);
        backTracking(root.right,target,sum);
        path.removeLast();
    }
}
