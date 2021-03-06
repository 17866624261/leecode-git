import java.util.Scanner;

public class CrossLinkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? pB : pA.next;
            pB = pB == null ? pA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intersectVal = sc.nextInt();


    }
}
