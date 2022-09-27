import java.util.ArrayDeque;
import java.util.Deque;

public class Offer_24 {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur!=null){
            stack.offerFirst(cur);
            cur = cur.next;
        }
        ListNode newHead = stack.pollFirst();
        cur = newHead;
        while (!stack.isEmpty()){
            ListNode node = stack.pollFirst();
            cur.next = node;
            cur = node;
        }
        cur.next = null;
        return newHead;
    }
    public ListNode reverseList2(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
