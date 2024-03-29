/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        
        TreeNode temp = root;
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        
        while(temp != null){
            if(max < temp.val) temp = temp.left;
            else if(min > temp.val) temp = temp.right;
            else if(min <= temp.val && max >= temp.val) return temp;
        }
        
        return temp;
    }
}