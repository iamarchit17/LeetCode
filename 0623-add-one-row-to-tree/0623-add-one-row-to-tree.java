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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode insert = new TreeNode(val);
            insert.left = root;
            root = insert;
            return root;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        int count = 1;
        
        while(level < depth - 1){
            count--;
            TreeNode temp = q.poll();
            
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
            
            if(count == 0){
                count = q.size();
                level++;
            }
        }
        
        while(q.size() != 0){
            TreeNode temp = q.poll();
            TreeNode left = temp.left;
            TreeNode right = temp.right;
            
            temp.left = new TreeNode(val);
            temp.right = new TreeNode(val);
            
            temp.left.left = left;
            temp.right.right = right;
        }
        
        return root;
    }
}