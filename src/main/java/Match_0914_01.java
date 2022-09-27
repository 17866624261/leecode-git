import org.yaml.snakeyaml.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Match_0914_01 {
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        ListNode dN = new ListNode();
        dN.data = -1;
        dN.next = head;
        ListNode pre = dN;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 1; i <= right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dN.next;
    }
    public ListNode reverseList(ListNode head){
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

    class ListNode<T> {
        public T data;
        public ListNode next;
    }
}
