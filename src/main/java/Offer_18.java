public class Offer_18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        while (null != cur) {
            if (cur.val == val) {
                if (cur.next != null) {
                    cur.val = cur.next.val;
                    cur.next = cur.next.next;
                } else {
                    pre.next = null;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
