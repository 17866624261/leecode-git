import org.junit.Test;

import java.util.*;

public class Offer_06 {
    @Test
    public void testPrintReverse() {

    }

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return null;
        }
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            stack.offerFirst(cur);
            cur = cur.next;
        }
        int size = stack.size();
        int[] resA = new int[size];
        for (int i = 0; i < size; i++) {
            resA[i] = stack.pollFirst().val;
        }
        return resA;
    }
}
