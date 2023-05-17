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
    public TreeNode recoverFromPreorder(String traversal) {
        if(traversal.length() == 0) return null;
        
        int dashIndex = traversal.indexOf('-');
        if(dashIndex == -1) dashIndex = traversal.length();
        TreeNode root = new TreeNode(Integer.valueOf(traversal.substring(0, dashIndex)));
        
        
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.push(root);
        int level = 0;
        while(dashIndex < traversal.length()){
            int countDashes = 0;
            while(traversal.charAt(dashIndex) == '-'){
                dashIndex++;
                countDashes++;
            }
            
            int numIndex = dashIndex;
            dashIndex = traversal.indexOf('-', numIndex);
            if(dashIndex == -1) dashIndex = traversal.length();
            
            while(level != countDashes - 1){
                dq.pop();
                level--;
            }
            
            TreeNode temp = new TreeNode(Integer.valueOf(traversal.substring(numIndex, dashIndex)));
            if(dq.peek().left == null){
                dq.peek().left = temp;
            } else {
                dq.peek().right = temp;
            }
            
            level++;
            dq.push(temp);
        }
        
        return root;
    }
}