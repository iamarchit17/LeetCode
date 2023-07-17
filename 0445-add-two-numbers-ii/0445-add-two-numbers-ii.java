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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode sum = null;
        ListNode temp = null;
        int carry = 0;
        while(l1 != null && l2 != null){
            ListNode newNode = new ListNode((carry + l1.val + l2.val) % 10);
            if(sum == null){
                sum = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
            
            carry = (carry + l1.val + l2.val)/10;
            l1 = l1.next;
            l2 = l2.next;
             
        }
        
        if(l1 != null){
            while(l1 != null){
                ListNode newNode = new ListNode((l1.val + carry) % 10);
                carry = (carry + l1.val) / 10;
                l1 = l1.next;
                temp.next = newNode;
                temp = temp.next;
            }
        }
        
        if(l2 != null){
            while(l2 != null){
                ListNode newNode = new ListNode((l2.val + carry) % 10);
                carry = (carry + l2.val) / 10;
                l2 = l2.next;
                temp.next = newNode;
                temp = temp.next;
            }
        }
        
        if(carry != 0) temp.next = new ListNode(carry);
        
        return reverse(sum);
    }
    
    public ListNode reverse(ListNode l){
        if(l == null || l.next == null) return l;
        
        ListNode prev = null, curr = l, next = l.next;
        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }
        
        return prev;
    }
}

