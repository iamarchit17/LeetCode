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

class Pair{
    TreeNode node;
    int index;
    public Pair(TreeNode node, int index){
        this.node = node;
        this.index = index; 
    }
}


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Deque<Pair> dq = new ArrayDeque<>();
        dq.add(new Pair(root, 1));
        int maxWidth = 0;
        
        while(dq.size() != 0){
            int count = dq.size();
            int width = dq.peek().index;
            for(int i = 0; i < count; i++){
                Pair temp = dq.poll();
                if(temp.node.left != null) dq.add(new Pair(temp.node.left, temp.index * 2));
                if(temp.node.right != null) dq.add(new Pair(temp.node.right, temp.index * 2 + 1));
                
                if(i == count - 1){
                    width = temp.index - width + 1;
                    maxWidth = Math.max(maxWidth, width);
                }
            }
        }
        
        return maxWidth;
    }
}