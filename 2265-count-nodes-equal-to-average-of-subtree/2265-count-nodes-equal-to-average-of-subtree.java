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
    public int averageOfSubtree(TreeNode root) {
        int[] res = new int[1];
        averageOfSubtree(root, res);
        return res[0];
    }
    
    public int[] averageOfSubtree(TreeNode root, int[] res){
        if(root == null){
            int[] arr = {0, 0};
            return arr;
        }
        
        int[] x = averageOfSubtree(root.left, res);
        int[] y = averageOfSubtree(root.right, res);
        
        int[] arr = new int[2];
        arr[0] = x[0] + y[0] + root.val;
        arr[1] = x[1] + y[1] + 1;
        
        if(arr[0]/arr[1] == root.val) res[0]++;
        
        return arr;
    }
}