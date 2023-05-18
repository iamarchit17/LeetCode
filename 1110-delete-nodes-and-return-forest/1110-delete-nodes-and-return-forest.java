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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        List<TreeNode> list = new ArrayList<>();
        if(root == null) return list;
        
        HashSet<Integer> set = new HashSet<>(to_delete.length);
        for(int i : to_delete) set.add(i);
        
        delNodes(root, set, list, null);
        if(root.val != -1) list.add(root);
        return list;
        
    }
    
    public void delNodes(TreeNode root, HashSet<Integer> set, List<TreeNode> list, TreeNode parent){
        if(root == null) return;
        
        delNodes(root.left, set, list, root);
        delNodes(root.right, set, list, root);
        
        if(set.contains(root.val)){
            if(root.left != null){
                list.add(root.left);
                root.left = null;
            }
            
            if(root.right != null){
                list.add(root.right);
                root.right = null;
            }
            
            if(parent == null){
                root.val = -1;
            } else {
                if(parent.left == root) parent.left = null;
                else parent.right = null;
            }
        }
    }
}