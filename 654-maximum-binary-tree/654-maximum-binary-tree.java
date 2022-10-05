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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
    
    public TreeNode construct(int[] nums, int start, int end){
        if(end < start) return null;
        int max = nums[start];
        int j = start;
        for(int i = start + 1; i <= end; i++) {
            if(nums[i] > max){
                max = nums[i];
                j = i;
            }
        }
        
        TreeNode root = new TreeNode(max);
        root.left = construct(nums, start, j - 1);
        root.right = construct(nums, j + 1, end);
        
        return root;
        
    }
}
*/

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> s = new Stack<>();
        
        for(int i = 0; i < nums.length; i++){
            TreeNode temp = new TreeNode(nums[i]);
            
            while(!s.empty() && s.peek().val < temp.val){
                temp.left = s.pop();
            }
            
            if(!s.empty()) s.peek().right = temp;
            s.push(temp);
        }
        
        TreeNode root = null;
        while(!s.empty()) root = s.pop();
        return root;
    }
    
}