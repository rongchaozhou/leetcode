class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0), pre = dummy;
        dummy.next = head;
        while (m > 1) {
            pre = pre.next;
            m--;
            n--;
        }
        ListNode positionM = pre.next;
        ListNode tempPre = pre, tempCurr = tempPre.next, tempNext = tempCurr.next;
        while (n > 1) {
            tempCurr.next = tempPre;
            tempPre = tempCurr;
            tempCurr = tempNext;
            tempNext = tempNext.next;
            n--;
        }
        tempCurr.next = tempPre;
        pre.next = tempCurr;
        positionM.next = tempNext;
        return dummy.next;
    }
}
