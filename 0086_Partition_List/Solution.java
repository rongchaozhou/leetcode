class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy0 = new ListNode(0), dummy1 = new ListNode(0);
        ListNode less = dummy0, greater = dummy1;
        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        less.next = dummy1.next;
        greater.next = null;
        return dummy0.next;
    }
}
