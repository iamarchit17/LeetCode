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
    public int pairSum(ListNode head) {
        if(head == null) return -1;
        
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        
        head = reverse(head, size/2);
        
        ListNode fwd = head;
        int x = 0;
        while(x++ < size/2) fwd = fwd.next;
        ListNode bwd = head;
        
        int max = 0;
        while(fwd != null){
            max = Math.max(max, fwd.val + bwd.val);
            fwd = fwd.next;
            bwd = bwd.next;
        }
        
        return max;
        
    }
    
    public ListNode reverse(ListNode head, int size){
        ListNode curr = head;
        ListNode after = head.next;
        ListNode prev = null;
        
        int x = 0;
        while(x++ < size){
            curr.next = prev;
            prev = curr;
            curr = after;
            after = after.next;
        }
        
        head.next = curr;
        head = prev;
        
        return head;
    }
}