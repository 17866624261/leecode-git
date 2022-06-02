public class Leetcode_105 {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return traversal(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode traversal(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (inRight - inLeft < 1) {
            return null;
        }
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        // 递归的时候去掉根节点，根节点不需要参与递归
        root.left = traversal(preorder, preLeft + 1, preLeft + 1 + rootIndex - inLeft, inorder, inLeft, rootIndex);
        root.right = traversal(preorder, preLeft + 1 + rootIndex - inLeft, preRight, inorder, rootIndex + 1, inRight);
        return root;
    }
}
