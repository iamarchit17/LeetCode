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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        
        ListNode l = null;
        int count = 0;
        while(count < left - 1){
            l = l == null ? head : l.next;
            count++;
        }
        //send l.next for reverse    
        
        ListNode prev = l;
        ListNode curr = (l == null) ? head : l.next;
        ListNode next = curr.next;
        
        ListNode f = curr;
        
        int revs = 0;
        while(revs != right - left + 1){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
            revs++;
        }
        
        if(l == null) head = prev;
        else l.next = prev;
        
        f.next = curr;
        return head;
    }
    
    
}