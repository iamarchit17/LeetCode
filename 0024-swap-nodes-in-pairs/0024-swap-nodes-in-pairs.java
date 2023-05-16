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
    public ListNode swapPairs(ListNode head) {
    
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null && temp.next != null){
            ListNode l = temp.next.next; 
            if(temp == head){
                head = temp.next;
                head.next = temp;
                temp.next = l;
            } else {
                prev.next = temp.next;
                prev.next.next = temp;
                temp.next = l;
            }
            
            prev = temp;
            temp = temp.next;
        }
        
        return head;
    }
}