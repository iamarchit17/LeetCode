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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode counter = head;
        
        while(counter.next != null){
            ListNode temp = head;
            if(head.val > counter.next.val){
                ListNode s = counter.next;
                counter.next = s.next;
                s.next = head;
                head = s;
            } else{
                while(temp != counter && temp.next.val < counter.next.val) temp = temp.next;
                if(temp != counter){
                    ListNode s = temp.next;
                    temp.next = counter.next;
                    counter.next = temp.next.next;
                    temp.next.next = s;
                } else {
                    counter = counter.next;
                }
            }
        }
        
        return head;
    }
}