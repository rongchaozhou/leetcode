class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int adder = 0;
        ListNode curr = new ListNode(0);
        while (!stack1.isEmpty() || !stack2.isEmpty() || adder != 0) {
            if (!stack1.isEmpty()) {
                adder += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                adder += stack2.pop();
            }
            curr.val = adder % 10;
            ListNode pre = new ListNode(0);
            pre.next = curr;
            curr = pre;
            adder /= 10;
        }
        return curr.next;
    }
}
