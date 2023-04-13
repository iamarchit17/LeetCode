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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] index = {postorder.length - 1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTree(postorder, map, 0, postorder.length - 1, index);
    }
    
    public TreeNode buildTree(int[] postorder, HashMap<Integer, Integer> map, int low, int high, int[] index){
        if(low > high) return null;
        if(low == high) return new TreeNode(postorder[index[0]--]);
        
        TreeNode root = new TreeNode(postorder[index[0]--]);
        int x = map.get(root.val);
        root.right = buildTree(postorder, map, x + 1, high, index);
        root.left = buildTree(postorder, map, low, x - 1, index);
        
        return root;
    }
}