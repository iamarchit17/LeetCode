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

//Inorder traversal method
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        int[] index = new int[1];
        
        return bstFromPreorder(preorder, map, 0, inorder.length - 1, index);
        
    }
    
    public TreeNode bstFromPreorder(int[] preorder, HashMap<Integer, Integer> map, int low, int high, int[] index){
        if(low > high) return null;
        if(low == high) return new TreeNode(preorder[index[0]++]);
        
        TreeNode root = new TreeNode(preorder[index[0]++]);
        int x = map.get(root.val);
        root.left = bstFromPreorder(preorder, map, low, x-1, index);
        root.right = bstFromPreorder(preorder, map, x+1, high, index);
        
        return root;
        
    }
}