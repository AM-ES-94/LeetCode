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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next;
        ListNode result = new ListNode();
        ListNode resultHead = result;
        int sum = 0;

        while(temp != null){
            if (temp.val == 0){
                ListNode add = new ListNode(sum);
                sum = 0;
                result.next = add;
                result = result.next;
            }
            else sum += temp.val;
            temp = temp.next;
        }

        return resultHead.next;
    }
}