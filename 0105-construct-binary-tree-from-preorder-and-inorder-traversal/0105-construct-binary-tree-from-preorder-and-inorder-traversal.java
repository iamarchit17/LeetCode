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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] index = {0};
        return buildTree(preorder, inorder, 0, preorder.length - 1, index);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int low, int high, int[] index){
        if(low > high) return null;
        if(low == high){
            TreeNode temp = new TreeNode(preorder[index[0]]);
            index[0]++;
            return temp;
        }
        
        TreeNode root = new TreeNode(preorder[index[0]]);
        int i = low;
        for(; i <= high; i++) if(inorder[i] == preorder[index[0]]) break;
        index[0]++;
        root.left = buildTree(preorder, inorder, low, i - 1, index);
        root.right = buildTree(preorder, inorder, i + 1, high, index);
        
        return root;
    }
}