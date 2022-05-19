import java.util.ArrayDeque;
import java.util.Deque;

public class Leecode_116 {
    public static void main(String[] args) {

    }

    public static PNode connect(PNode root) {
        Deque<PNode> queue = new ArrayDeque<>();
        PNode res = root;
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                PNode node = queue.poll();
                if (queue.isEmpty()) {
                    node.next = null;
                } else if (i == size - 1){
                    node.next = null;
                }else {
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

class PNode {
    public int val;
    public PNode left;
    public PNode right;
    public PNode next;

    public PNode() {
    }

    public PNode(int val, PNode left, PNode right, PNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public PNode(int val) {
        this.val = val;
    }
}
