class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        while (slow.next != null) {
            if (slow.next.val == slow.val) {
                slow.next = slow.next.next;
            } else {
                slow = slow.next;
            }
        }
        return head;
    }
}
