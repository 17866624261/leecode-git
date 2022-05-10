public class Kjinzhi {
//    public long minM(int n,int k){
//        ArrayList<Integer> nums = new ArrayList<>();
//
//
//    }
//    public TreeNode cyclicShiftTree (TreeNode root,int k){
//        List<List<TreeNode>> res = new ArrayList<>();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        if(root!=null)
//        {
//            queue.add(root);
//        }
//        while (!queue.isEmpty())
//        {
//            int n = queue.size();
//            List<TreeNode> level = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                TreeNode node = queue.poll();
//                level.add(node);
//                if(node.val!=-1) {
//                    if (node.left != null) {
//                        queue.add(node.left);
//                    } else {
//                        queue.add(new TreeNode(-1));
//                    }
//
//                    if (node.right != null) {
//                        queue.add(node.right);
//                    } else {
//                        queue.add(new TreeNode(-1));
//                    }
//                }
//
//            }
//            res.add(level);
//        }
//        return res;
//    }
}
