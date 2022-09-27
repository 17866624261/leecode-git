public class Offer_36 {
    // 树的题明白不同遍历的遍历顺序，然后在当前节点操作的时候按照链表画法遍历操作即可。
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        bakcTracking(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public void bakcTracking(Node cur){
        if (cur == null)
            return;
        bakcTracking(cur.left);
        // pre为空的时候遍历到第一个节点
        if (pre != null) pre.right = cur;
        // 将head指向第一个节点
        else head = cur;
        // 当前节点指向前驱节点
        cur.left = pre;
        // 回溯后前驱节点变为当前节点
        pre = cur;
        bakcTracking(cur.right);
    }
    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
