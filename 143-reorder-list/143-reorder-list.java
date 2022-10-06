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
    public void reorderList(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;
        while(temp != null){
            st.push(temp);
            temp = temp.next;
        }
        
        
        
        temp = head;
        while(!(st.peek() == temp || st.peek() == temp.next)){
            st.peek().next = temp.next;
            temp.next = st.pop();
            temp = temp.next.next;
        }
        
        if(st.peek() == temp) temp.next = null;
        else temp.next.next = null;
        
    }
}