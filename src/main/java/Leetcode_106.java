public class Leetcode_106 {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode traversal(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inRight - inLeft < 1) {
            return null;
        }
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }
        int rootValue = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = 0;
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        // 中序数组要去掉中间的根节点
        // 后序数组要去掉结尾的根节点
        root.left = traversal(inorder, inLeft, rootIndex, postorder, postLeft, postLeft + (rootIndex - inLeft));
        root.right = traversal(inorder, rootIndex + 1, inRight, postorder, postLeft + (rootIndex - inLeft), postRight - 1);
        return root;
    }
}
