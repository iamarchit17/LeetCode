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
    public int maxDepth(TreeNode root) {
        int[] max = {0};
        maxDepth(root, max, 1);
        return max[0];
    }
    
    public void maxDepth(TreeNode root, int[] max, int depth){
        if(root == null) return;
        
        if(depth > max[0]) max[0] = depth;
        maxDepth(root.left, max, depth + 1);
        maxDepth(root.right, max, depth + 1);
    }
}