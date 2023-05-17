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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        
        TreeNode temp = root;
        TreeNode prev = null;
        
        while(temp != null){
            if(val > temp.val){
                TreeNode insert = new TreeNode(val);
                if(temp == root){
                    root = insert;
                    insert.left = temp;
                    return root;
                } else {
                    prev.right = insert;
                    insert.left = temp;
                    return root;
                }
            }
            
            prev = temp;
            temp = temp.right;
        }
        
        prev.right = new TreeNode(val);
        return root;
        
    }
}