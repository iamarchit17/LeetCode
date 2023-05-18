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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        TreeNode opponent = null;
        int totalNodes = 0;
        
        while(q.size() != 0){
            totalNodes++;
            TreeNode temp = q.poll();
            if(temp.val == x) opponent = temp;
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
        }
        
        int leftNodes = countNodes(opponent.left);
        int rightNodes = countNodes(opponent.right);
        int parentNodes = totalNodes - leftNodes - rightNodes - 1;
        
        if(parentNodes > leftNodes + rightNodes + 1) return true;
        if(leftNodes > parentNodes + rightNodes + 1) return true;
        if(rightNodes > parentNodes + leftNodes + 1) return true;
        
        return false;        
    }
    
    public int countNodes(TreeNode root){
        if(root == null) return 0;
        
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        
        return 1 + left + right;
    }
    
    
}