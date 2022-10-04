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
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> s = new Stack<>();
        postorder(root, s);
        root = s.peek();
        TreeNode temp = null;
        while(s.size() != 1){
            temp = s.pop();
            temp.left = null;
            temp.right = s.peek();
        }
        
        temp = s.pop();
        temp.left = null;
        temp.right = null;
        
    }
    
    public void postorder(TreeNode root, Stack<TreeNode> s){
        if(root == null) return;
        postorder(root.right, s);
        postorder(root.left, s);
        s.push(root);
    }
}