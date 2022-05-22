public class Leetcode_110 {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) == -1 ? false : true;
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) return -1;
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : 1 + Math.max(leftHeight, rightHeight);
    }
}
