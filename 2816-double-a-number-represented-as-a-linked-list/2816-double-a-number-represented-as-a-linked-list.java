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
    public ListNode doubleIt(ListNode head) {
        int carry = recursive(head);
        return carry == 0 ? head : new ListNode(carry, head);        
    }
    
    private int recursive(ListNode head){
        if (head == null) return 0;
        
        int sum = recursive(head.next) + head.val * 2;
        head.val = sum % 10;
        return sum/10;
    }
}