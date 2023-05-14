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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = new int[1];
        int[] res = new int[1];
        
        inorder(root, count, res, k);
        return res[0];
    }
    
    public void inorder(TreeNode root, int[] count, int[] res, int k){
        if(root == null) return;
        inorder(root.left, count, res, k);
        count[0]++;
        if(count[0] == k){
            res[0] = root.val;
        }
        inorder(root.right, count, res, k);
    } 
}