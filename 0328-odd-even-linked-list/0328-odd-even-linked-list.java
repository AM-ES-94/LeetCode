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
    public ListNode oddEvenList(ListNode head) {
        
        if (head == null || head.next == null) return head;

        ListNode oddTemp = head;
        ListNode evenTemp = head.next;
        ListNode evenHead = head.next;

        while(evenTemp != null && evenTemp.next != null){
            oddTemp.next = oddTemp.next.next;
            evenTemp.next = evenTemp.next.next;

            oddTemp = oddTemp.next;
            evenTemp = evenTemp.next;
        }

        oddTemp.next = evenHead;

        return head;
    }
}