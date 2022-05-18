import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leecode_429 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                temp.add(node.val);
                if (node.children != null) {
                    for (Node te : node.children) {
                        queue.offer(te);
                    }
                }
            }
            res.add(temp);
        }
        return res;
    }
}
