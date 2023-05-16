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
    public int goodNodes(TreeNode root) {
        int[] count = new int[1];
        goodNodes(root, root.val, count);
        
        return count[0];
    }
    
    public void goodNodes(TreeNode root, int max, int[] count){
        if(root == null) return;
        
        if(root.val >= max){
            count[0]++;
            max = root.val;
        }
        
        goodNodes(root.left, max, count);
        goodNodes(root.right, max, count);
    }
}