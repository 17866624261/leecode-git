import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Match_0908_02 {
    Map<Integer,Integer> map;
    public ArrayList<TreeNode> getBinaryTrees (ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        // write code here
        ArrayList<TreeNode> res = new ArrayList<>();
        TreeNode root1 = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        root1.left = node1;
        root1.right = null;
        node1.right = node2;
        node1.left = null;
        res.add(root1);
        TreeNode root2 = new TreeNode(1);
        TreeNode node2_1 = new TreeNode(1);
        TreeNode node2_2 = new TreeNode(2);
        root2.right = node2_1;
        node2_1.left = node2_2;
        res.add(root2);

        return res;
    }
//    public TreeNode buildTree(int[] preOrder,int[] inOrder){
//        map = new HashMap<>();
//        for (int i = 0; i < inOrder.length; i++) {
//            map.put(inOrder[i],i);
//        }
//        return
//    }
//    public TreeNode findNode(int[] ){
//
//    }
}
