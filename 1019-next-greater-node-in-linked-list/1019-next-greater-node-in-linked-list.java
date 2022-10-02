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
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        int n = 0;
        ListNode itr = head;
        while(itr != null){
            while(!s.empty() && s.peek().val < itr.val){
                s.peek().val = itr.val;
                s.pop();
            }
            
            s.push(itr);
            itr = itr.next;
            n++;
        }
        
        while(!s.empty()) s.pop().val = 0;
        int[] res = new int[n];
        itr = head;
        for(int i = 0; i < n; i++){
            res[i] = itr.val;
            itr = itr.next;
        }

        return res;
    
    }
}