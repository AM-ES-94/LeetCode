/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        
        ListNode fastP = head;
        ListNode slowP = head;

        for (int i = 0; i < n; ++i){
            fastP = fastP.next;
        }

        if (fastP == null) return head.next;

        while (fastP.next != null){
            fastP = fastP.next;
            slowP = slowP.next;
        }

        slowP.next = slowP.next.next;
        return head;
    }
}