public class Match_0914_02 {
    Node preNode, head;

    public Node Convert(Node pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        backTracking(pRootOfTree);
        return head;
    }

    public void backTracking(Node curNode) {
        if (curNode == null) return;
        backTracking(curNode.left);
        curNode.left = preNode;
        if (preNode != null) {
            preNode.right = curNode;
        } else {
            head = curNode;
        }
        preNode = curNode;
        backTracking(curNode.right);
    }

    class Node {
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
