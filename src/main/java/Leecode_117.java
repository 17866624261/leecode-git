import java.util.ArrayDeque;
import java.util.Deque;

public class Leecode_117 {
    public static void main(String[] args) {

    }

    public static Node2 connect(Node2 root) {
        Deque<Node2> queue = new ArrayDeque<>();
        Node2 res = root;
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node2 node = queue.poll();
                if (queue.isEmpty()) {
                    node.next = null;
                } else if (i == size - 1) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}

class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;
    public Node2 next;

    public Node2() {
    }

    public Node2(int val, Node2 left, Node2 right, Node2 next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public Node2(int val) {
        this.val = val;
    }
}
