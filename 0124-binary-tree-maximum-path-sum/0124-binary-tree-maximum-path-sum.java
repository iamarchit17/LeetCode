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
    public int maxPathSum(TreeNode root) {
        int[] maxsum = new int[1];
        maxsum[0] = Integer.MIN_VALUE;        
        maxPathSum(root, maxsum);
        
        return maxsum[0];
    }
    
    public int maxPathSum(TreeNode root, int[] maxsum){
        if(root == null) return 0;
        
        int x = Math.max(0, maxPathSum(root.left, maxsum));
        int y = Math.max(0, maxPathSum(root.right, maxsum));
        
        maxsum[0] = Math.max(maxsum[0], x + y + root.val);
        
        return root.val + Math.max(x, y);
    }
}