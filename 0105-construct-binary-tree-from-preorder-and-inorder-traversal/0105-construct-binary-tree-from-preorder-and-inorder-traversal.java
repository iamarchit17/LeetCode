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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] index = {0};
        return buildTree(preorder, inorder, 0, preorder.length - 1, index);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int low, int high, int[] index){
        if(low > high) return null;
        
        TreeNode root = new TreeNode(preorder[index[0]]);
        int i = low;
        for(; i <= high; i++) if(inorder[i] == preorder[index[0]]) break;z
        index[0]++;
        root.left = buildTree(preorder, inorder, low, i - 1, index);
        root.right = buildTree(preorder, inorder, i + 1, high, index);
        
        return root;
    }
}
*/

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] index = {0};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return buildTree(preorder, map, 0, preorder.length - 1, index);
    }
    
    public TreeNode buildTree(int[] preorder, HashMap<Integer, Integer> map, int low, int high, int[] index){
        if(low > high) return null;
        if(low == high) return new TreeNode(preorder[index[0]++]);
            
        TreeNode root = new TreeNode(preorder[index[0]++]);
        int x = map.get(root.val);
        root.left = buildTree(preorder, map, low, x - 1, index);
        root.right = buildTree(preorder, map, x + 1, high, index);
        
        return root;
    }
}
