public class Offer_52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0, sizeB = 0, div = 0;
        ListNode curA = headA, curB = headB;
        while (curA != null) {
            sizeA++;
            curA = curA.next;
        }
        while (curB != null) {
            sizeB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        div = sizeA > sizeB ? sizeA - sizeB : sizeB - sizeA;
        if (sizeA > sizeB) {
            for (int i = 0; i < div; i++) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < div; i++) {
                curB = curB.next;
            }
        }
        while (curA != null && curB != null) {
            if (curA == curB)
                return curA;
            else {
                curA = curA.next;
                curB = curB.next;
            }
        }
        return null;
    }

    ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 某个节点遍历到空的时候换到另一个链表的头，等待双方都交换之后就是从后往前相同位置的地方开始遍历，找到同一个指向的节点或者null即可
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
