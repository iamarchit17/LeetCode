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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        pathSum(root, list, l, targetSum, 0);
        return list;
    }
    
    public void pathSum(TreeNode root, List<List<Integer>> list, List<Integer> l, int targetSum, int sum){
        if(root == null) return;
        
        sum += root.val;
        l.add(root.val);
        if(root.left == null && root.right == null && sum == targetSum) list.add(new ArrayList<>(l));
        
        pathSum(root.left, list, l, targetSum, sum);
        pathSum(root.right, list, l, targetSum, sum);
        
        l.remove(l.size() - 1);
    }
}