import java.util.HashMap;
import java.util.Map;

public class Offer_07 {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode myBuildTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right) {
            return null;
        }
        int preorder_root = preorder[pre_left];
        // 根节点在中序遍历中的位置
        int inorder_root = indexMap.get(preorder_root);
        TreeNode root = new TreeNode(preorder_root);
        // 得到左子树的节点数目
        int size_left_subtree = inorder_root - in_left;
        root.left = myBuildTree(preorder, inorder, pre_left + 1, size_left_subtree + pre_left, in_left, inorder_root - 1);
        root.right = myBuildTree(preorder, inorder, size_left_subtree + pre_left + 1, pre_right, inorder_root + 1, in_right);
        return root;
    }
}
