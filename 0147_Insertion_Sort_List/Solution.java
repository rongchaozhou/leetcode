import java.util.*;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head, curr = head.next;
        while(curr != null){
            if(pre.val <= curr.val){
                curr = curr.next;
                pre = pre.next;
                continue;
            }
            pre.next = curr.next;
            curr.next = null;
            ListNode searcher = dummy;
            while(searcher.next.val < curr.val){
                searcher = searcher.next;
            }
            curr.next = searcher.next;
            searcher.next = curr;
            curr = pre.next;
        }
        return dummy.next;
    }
}