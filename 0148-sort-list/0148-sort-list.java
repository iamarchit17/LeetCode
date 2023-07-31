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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode mid = middle(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        
        left = sortList(left);
        right = sortList(right);
        
        ListNode mergedList = merge(left, right);
        return mergedList;
        
    }
    
    public ListNode middle(ListNode head){
        ListNode slow = null;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow == null ? head : slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode merge(ListNode a, ListNode b){
        ListNode head = null;
        ListNode prev = null;
        
        while(a != null && b != null){
            int d = a.val < b.val ? a.val : b.val;
            if(a.val < b.val) a = a.next;
            else b = b.next;
            
            ListNode temp = new ListNode(d);
            if(head == null){
                head = temp;
                prev = temp;
            } else {
                prev.next = temp;
                prev = temp;
            }
        }
        
        while(a != null){
            prev.next = new ListNode(a.val);
            prev = prev.next;
            a = a.next;
        }
        
        while(b != null){
            prev.next = new ListNode(b.val);
            prev = prev.next;
            b = b.next;
        }
        
        return head;
    }
}

