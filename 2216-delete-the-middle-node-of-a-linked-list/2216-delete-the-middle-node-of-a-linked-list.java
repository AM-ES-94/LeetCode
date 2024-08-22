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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fastP = head.next.next;
        ListNode slowP = head;

        while (fastP != null && fastP.next != null){
            fastP = fastP.next.next;
            slowP = slowP.next;
        }

        slowP.next = slowP.next.next;
        return head;
    }
}