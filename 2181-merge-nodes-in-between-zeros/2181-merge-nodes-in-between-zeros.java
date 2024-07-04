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
        ListNode newHead = new ListNode(0);
        ListNode current = newHead;


        int sum = 0;
        // skip first zero
        head = head.next;
        while(head != null){
            if(head.val == 0){
                ListNode temp = new ListNode(sum);
                current.next = temp;
                current = current.next;
                sum = 0;
            }else{
                sum += head.val;
            }
            head = head.next;
        }

        return newHead.next;
    }
}