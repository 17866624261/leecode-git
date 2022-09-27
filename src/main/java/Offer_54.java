public class Offer_54 {
    private int count,res;
    public int kthLargest(TreeNode root, int k) {
        count = 0;
        recur(root,k);
        return res;
    }
    public void recur(TreeNode cur,int k){
        if (cur == null) return;
        recur(cur.right,k);
        if (count == k) return;
        count++;
        if (count == k) res = cur.val;
        recur(cur.left,k);
    }
}
