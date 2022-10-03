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
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        inOrder(root, s);
        root = s.peek();
        TreeNode temp = null;
        while(s.size() != 1){
            temp = s.pop();
            temp.left = null;
            temp.right = s.peek();
        }
        
        temp = s.pop();
        temp.left = temp.right = null;
        
        return root;
    }
    
    public void inOrder(TreeNode root, Stack<TreeNode> s){
        if(root == null) return;
        
        inOrder(root.right, s);
        s.push(root);
        inOrder(root.left, s);
    }
}