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

/*
class Solution {
    public int minDepth(TreeNode root) {
        int[] depth = {Integer.MAX_VALUE};
        inorder(root, depth, 1);
        return depth[0] == Integer.MAX_VALUE ? 0 : depth[0];
    }
    
    public void inorder(TreeNode root, int[] depth, int d){
        if(root == null) return;
        
        if(root.left == null && root.right == null && d < depth[0]) depth[0] = d;
        inorder(root.left, depth, d+1);
        inorder(root.right, depth, d+1);
    }
}
*/

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        
        while(q.size() != 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                
                if(temp.left == null && temp.right == null) return depth;
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            depth++;
        }
        
        return -1;
    }
}