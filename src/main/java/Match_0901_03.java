import java.util.ArrayList;
import java.util.List;

public class Match_0901_03 {
    private List<TreeNode> res = new ArrayList<>();
    public TreeNode[] balanceSubTree (TreeNode root) {
        // write code here
        backTracking(root,0);
        TreeNode[] result = new TreeNode[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    public int backTracking(TreeNode cur,int count){
        if (cur == null)
            return 0;
        int leftCount = backTracking(cur.left,count);
        int rightCount = backTracking(cur.right,count);
        if (leftCount - rightCount > 1){
            res.add(cur.left);
            cur.left = null;
            count = rightCount + 1;
        }else if (rightCount - leftCount > 1){
            res.add(cur.right);
            cur.right = null;
            count = leftCount + 1;
        }
        return count;
    }
}
