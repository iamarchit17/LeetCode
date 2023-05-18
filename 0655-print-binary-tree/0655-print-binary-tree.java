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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> list = new ArrayList<>();
        
        int h = height(root);
        int w = (1 << h) - 1;
        for(int i = 0; i < h; i++){
            List<String> l = new ArrayList<>();
            for(int j = 0; j < w; j++){
                l.add("");
            }
            list.add(l);
        }
        
        place(root, 0, (w - 1)/2, h - 1, list);
        return list;
    }
    
    public int height(TreeNode root){
        if(root == null) return 0;
        
        int x = height(root.left);
        int y = height(root.right);
        
        return Math.max(x, y) + 1;
    }
    
    public void place(TreeNode root, int r, int c, int height, List<List<String>> list){
        if(root == null) return;
        
        list.get(r).set(c, String.valueOf(root.val));
        place(root.left, r + 1, c - (1 << (height - r - 1)), height, list);
        place(root.right, r + 1, c + (1 << (height - r - 1)), height, list);     
    }
}