public class TestQuyu {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void main(String[] args) {
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode mid = l3;
        int ca = 0;
        while((l1!=null) || (l2!=null)){
            int remain = (l1.val+l2.val)%10;
            mid.val = remain+ca;
            mid.next = new ListNode();
            mid = mid.next;
            ca = (l1.val+l2.val)/10%10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (null == l1){
            while(null != l2){
                mid.val = l2.val;
                mid.next = new ListNode();
                mid = mid.next;
                l2 = l2.next;
            }
        }
        if (null == l2){
            while(null != l1){
                mid.val = l1.val;
                mid.next = new ListNode();
                mid = mid.next;
                l1 = l1.next;
            }
        }
        return l3;
    }
}
