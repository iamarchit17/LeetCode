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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        postorder(root, map, list);
        
        return list;
    }
    
    public String postorder(TreeNode root, HashMap<String, Integer> map, List<TreeNode> list){
        if(root == null) return "";
        
        String left = postorder(root.left, map, list);
        String right = postorder(root.right, map, list);
        
        String res = "(" + left + String.valueOf(root.val) + right + ")";
        map.put(res, map.getOrDefault(res, 0) + 1);
        if(map.get(res) == 2) list.add(root);
        
        return res;
    }
    
    
}