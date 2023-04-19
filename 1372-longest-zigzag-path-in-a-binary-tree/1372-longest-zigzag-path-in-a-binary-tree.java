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
    public int longestZigZag(TreeNode root) {
        if(root == null) return 0;
        int[] max = new int[1];
        if(root.left != null) longestZigZag(root.left, 'l', max, 1);
        if(root.right != null) longestZigZag(root.right, 'r', max, 1);
        
        return max[0];
    }
    
    public void longestZigZag(TreeNode root, char dir, int[] max, int curr){
        if(root == null) return;
        
        if(curr > max[0]) max[0] = curr;
        if(dir == 'r'){
            longestZigZag(root.left, 'l', max, curr + 1);
            longestZigZag(root.right, 'r', max, 1);
        } else {
            longestZigZag(root.left, 'l', max, 1);
            longestZigZag(root.right, 'r', max, curr + 1);
        }
        
    }
}