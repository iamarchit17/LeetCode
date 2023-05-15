/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> dq = new LinkedList<>();
        boolean evenLevel = true;
        
        dq.add(root);
        int count = 1;
        int prev = Integer.MIN_VALUE;
        
        while(dq.size() != 0){
            count--;
            TreeNode temp = dq.poll();
            
            if(evenLevel && (temp.val <= prev || temp.val % 2 == 0)) return false;
            if(!evenLevel && (temp.val >= prev || temp.val % 2 == 1)) return false;
            
            prev = temp.val;
            if(temp.left != null) dq.add(temp.left);
            if(temp.right != null) dq.add(temp.right);
            
            if(count == 0){
                count = dq.size();
                evenLevel = !evenLevel;
                prev = (evenLevel) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        
        return true;
    }
}