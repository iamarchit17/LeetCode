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
    public List<TreeNode> allPossibleFBT(int n) {
        List<List<TreeNode>> dp = new ArrayList<>();
        for(int i = 0; i <= n; i++) dp.add(new ArrayList<>());
        
        return allPossibleFBT(n, dp);
    }
    
    public List<TreeNode> allPossibleFBT(int n, List<List<TreeNode>> dp){
        
        if(n == 1) {
            ArrayList<TreeNode> res = new ArrayList<>();
            res.add(new TreeNode(0));
            return res;
        }
        
        if(n % 2 == 0) return new ArrayList<TreeNode>();
        
        
        if(dp.get(n).size() != 0) return dp.get(n);
        
        for(int i = 2; i < n; i += 2){
            List<TreeNode> left = allPossibleFBT(i-1, dp);
            List<TreeNode> right = allPossibleFBT(n - i, dp);
            
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    dp.get(n).add(root);
                }
            }
        }
        
        return dp.get(n);
    }
}