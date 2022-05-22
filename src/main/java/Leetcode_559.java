import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode_559 {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        Deque<Node> queue = new ArrayDeque<>();
        int deep = 0;
        if (root == null) {
            return deep;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            deep++;
        }
        return deep;
    }
}
