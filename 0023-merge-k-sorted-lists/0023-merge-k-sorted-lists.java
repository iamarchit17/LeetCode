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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Math.max(1, lists.length), 
                                                        (l1, l2) -> l1.val - l2.val);
        
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) pq.add(lists[i]);
        }
        
        ListNode head = null;
        ListNode curr = null;
        
        while(pq.size() != 0){
            ListNode temp = new ListNode(pq.peek().val);
            
            if(head == null){
                head = temp;
            } else {
                curr.next = temp;
            }
            
            curr = temp;
            
            ListNode l = pq.poll();
            l = l.next;
            if(l != null) pq.add(l);
        }
        
        return head;
    }
}