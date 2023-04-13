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

//O(n) time and space, level order
/*
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        
        int count = 0;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        int flag = 0;
        while(dq.size() != 0){
            int s = dq.size();
            count += s;
            for(int i = 0; i < s; i++){
                TreeNode temp = dq.poll();
                if(temp.left != null){
                    dq.add(temp.left);
                } else {
                    flag = 1;
                }
                
                if(temp.right != null){
                    dq.add(temp.right);
                } else {
                    flag = 1;
                }
            }
            
            if(flag == 1) break;  
        }
        
        return count + dq.size();
    }
}
*/

//O(n) time and O(log n) space
//any dfs traversal
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int[] count = new int[1];
        countNodes(root, count);
        return count[0];
    }
    
    public void countNodes(TreeNode root, int[] count){
        if(root == null) return;
        count[0]++;
        countNodes(root.left, count);
        countNodes(root.right, count);
    }
}




