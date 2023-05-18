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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        
        for(int i = 0; i < descriptions.length; i++){
            boolean leftChild = descriptions[i][2] == 1;
            int child = descriptions[i][1];
            int parent = descriptions[i][0];
            
            TreeNode childNode = map.containsKey(child) ? map.get(child) : new TreeNode(child);
            if(map.containsKey(parent)){
                TreeNode parentNode = map.get(parent);
                if(leftChild) parentNode.left = childNode;
                else parentNode.right = childNode;
                map.replace(parent, parentNode);
            } else{
                TreeNode parentNode = new TreeNode(parent);
                if(leftChild) parentNode.left = childNode;
                else parentNode.right = childNode;
                map.put(parent, parentNode);
            }
            
            map.put(child, map.getOrDefault(child, childNode));
        }
        
        for(int i = 0; i < descriptions.length; i++){
            map.remove(descriptions[i][1]);
        }
        
        TreeNode res = null;
        for(Map.Entry<Integer, TreeNode> entry : map.entrySet()){
            res = entry.getValue();
        }
        
        return res;
    }
}