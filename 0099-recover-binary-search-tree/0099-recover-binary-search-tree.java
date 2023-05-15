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
    public void recoverTree(TreeNode root) {
        TreeNode[] violated = new TreeNode[3];
        violated[0] = violated[1] = violated[2] = null;
        TreeNode[] prev = new TreeNode[1];
        prev[0] = null;
        
        inorder(root, violated, prev);
        if(violated[2] == null){
            int x = violated[0].val;
            violated[0].val = violated[1].val;
            violated[1].val = x;
        } else {
            int x = violated[0].val;
            violated[0].val = violated[2].val;
            violated[2].val = x;
        }
    }
    
    public void inorder(TreeNode root, TreeNode[] violated, TreeNode[] prev){
        if(root == null) return;
        
        inorder(root.left, violated, prev);
        
        if(prev[0] != null && root.val < prev[0].val){
            if(violated[0] == null){
                violated[0] = prev[0];
                violated[1] = root;
            } else {
                violated[2] = root;
            }
        }
        
        prev[0] = root;
        inorder(root.right, violated, prev);
    }
}