class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode oldEnd = dummy, newEnd = dummy;
        int length = 0;
        while (oldEnd.next != null) {
            oldEnd = oldEnd.next;
            length++;
        }
        for (int i = length - k % length; i > 0; i--) {
            newEnd = newEnd.next;
        }
        oldEnd.next = dummy.next;
        dummy.next = newEnd.next;
        newEnd.next = null;
        return dummy.next;
    }
}
