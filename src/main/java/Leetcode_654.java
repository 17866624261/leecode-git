public class Leetcode_654 {
    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return traversal(nums, 0, nums.length);
    }

    public TreeNode traversal(int[] nums, int left, int right) {
        if (right - left < 1) {
            return null;
        }
        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }

        int rootIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[rootIndex]) {
                rootIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = traversal(nums, left, rootIndex);
        root.right = traversal(nums, rootIndex + 1, right);
        return root;
    }
}
