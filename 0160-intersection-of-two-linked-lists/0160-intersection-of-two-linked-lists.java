/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1 = 0;
        int size2 = 0;
        
        ListNode temp = headA;
        while(temp != null){
            size1++;
            temp = temp.next;
        }
        
        temp = headB;
        while(temp != null){
            size2++;
            temp = temp.next;
        }
        
        int diff = Math.abs(size1 - size2);
        
        temp = size1 > size2 ? headA : headB;
        ListNode temp2 = size1 > size2 ? headB : headA;
        while(diff-- > 0) temp = temp.next;
        
        while(temp != null && temp2 != null){
            if(temp == temp2) return temp;
            temp = temp.next;
            temp2 = temp2.next;
        }
        
        return null;
        
    }
}