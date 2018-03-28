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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode mid = head;
        while(p2 != null && p2.next != null){
            mid = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        mid.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(p1);
        return mergeTwoLists(l1, l2);
    }
}