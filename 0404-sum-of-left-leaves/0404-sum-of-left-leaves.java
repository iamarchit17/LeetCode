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
    public int sumOfLeftLeaves(TreeNode root) {
        int[] sum = new int[1];
        sumOfLeftLeaves(root, sum);
        return sum[0];
    }
    
    public void sumOfLeftLeaves(TreeNode root, int[] sum){
        if(root == null) return;
        
        sumOfLeftLeaves(root.left, sum);
        sumOfLeftLeaves(root.right, sum);
        
        if(root.left != null && root.left.left == null && root.left.right == null) sum[0] += root.left.val;
    }
}