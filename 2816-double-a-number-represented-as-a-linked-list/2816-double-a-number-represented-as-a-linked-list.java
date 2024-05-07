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
        if(head == null)
            return null;

        ListNode newHead = reverse(head);
        ListNode current = newHead;
        int remainder = 0;
        while(current != null){
            int value = current.val * 2 + remainder;
            if(value >= 10){
                value = value % 10;
                remainder = 1;
            }else{
                remainder = 0;
            }
            current.val = value;
            current = current.next;
        }
        
        head = reverse(newHead);


        if(remainder == 1){
            ListNode justTheTip = new ListNode(1);
            justTheTip.next = head;
            head = justTheTip;
        }
        return head;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }
}