import org.junit.Test;

public class Match_0901_01 {
    public ListNode mergeNode(ListNode head) {
        // write code here
        if (head == null || head.next == null)
            return null;
        ListNode pre = head;
        ListNode fast = head.next;
        ListNode cur = new ListNode((pre.val * fast.val));
        ListNode newHead = cur;
        pre = fast.next;
        if (pre != null)
            fast = pre.next;
        while (pre != null && fast != null) {
            cur.next = new ListNode((pre.val * fast.val));
            pre = fast.next;
            if (pre != null){
                fast = pre.next;
                cur = cur.next;
            }else {
                break;
            }
        }
        return newHead;
    }
    @Test
    public void test(){
        ListNode head = new ListNode(2);
        ListNode p2 = new ListNode(3);
        ListNode p3 = new ListNode(5);
        ListNode p4 = new ListNode(1);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(7);
        head.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        ListNode cur = mergeNode(head);
        while (cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
