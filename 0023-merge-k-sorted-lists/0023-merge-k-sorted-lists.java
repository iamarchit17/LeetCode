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
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Math.max(1, lists.length), (l1, l2) -> l1.val - l2.val);
        
        ListNode head = null;
        ListNode curr = null;
        
        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null) pq.add(lists[i]);
        }
        
        while(pq.size() != 0){
            ListNode temp = new ListNode(pq.peek().val);
            if(curr == null){
                head = temp;
                curr = head;
            }
            else{
                curr.next = temp;
                curr = curr.next;
            }
            
            if(pq.peek().next != null) pq.add(pq.peek().next);
            pq.poll();
            
        }
        
        return head;
    }
}