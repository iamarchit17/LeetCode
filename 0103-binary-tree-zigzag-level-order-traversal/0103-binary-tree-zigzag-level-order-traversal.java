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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        
        Queue<TreeNode> q = new LinkedList<>();
        int count = 1;
        q.add(root);
        List<Integer> l = new ArrayList<>();
        while(q.size() != 0){
            count--;
            TreeNode temp = q.poll();
            l.add(temp.val);
            if(temp.left != null) q.add(temp.left);
            if(temp.right != null) q.add(temp.right);
            
            if(count == 0){
                count = q.size();
                if(list.size() % 2 == 0) list.add(l);
                else{
                    Collections.reverse(l);
                    list.add(l);
                } 
                l = new ArrayList<>();
            }
        }
        return list;
    }
}