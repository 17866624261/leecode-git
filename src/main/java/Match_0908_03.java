public class Match_0908_03 {

    public int getTreeSum(TreeNode tree) {
        // write code here
        return treeNodeNum(tree);
    }

    public int treeNodeNum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftNum = treeNodeNum(node.left);
        int rightNum = treeNodeNum(node.right);

        return (Math.max(leftNum, rightNum) * 2 + 1)%1000000007;
    }
}
