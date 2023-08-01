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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode prevMiddle = middle(head);
        prevMiddle.next = reverse(prevMiddle.next);
        
        ListNode temp = head;
        ListNode temp2 = prevMiddle.next;
        
        while(temp2 != null){
            if(temp.val != temp2.val) return false;
            temp = temp.next;
            temp2 = temp2.next;
        }
        
        return true;
        
    }
    
    public ListNode middle(ListNode head){
        ListNode slow = null;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow == null ? head : slow.next;
            fast = fast.next.next;
        }
        
        return fast != null && fast.next == null ? slow.next : slow;
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;
        
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }
        
        return prev;
    }
}