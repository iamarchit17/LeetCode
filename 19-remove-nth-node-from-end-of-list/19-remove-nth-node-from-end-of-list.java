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
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        
        int temp = 0;
        while(temp < n){
            if(fast.next == null) break;
            fast = fast.next;
            temp++;
        }
        
        if(temp == n-1){
            head = head.next;
        } else if(temp == n){
            while(fast.next != null){
                slow = slow.next;
                fast = fast.next;
            }
            
            slow.next = slow.next.next;
        } else {
            head = null;
        }
        
        return head;
        
    }
}