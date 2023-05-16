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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(1000, (l1, l2) -> 
                                                      ((l1[0] - l2[0] == 0) ?
                                                       ((l1[1] - l2[1] == 0) ?
                                                        l1[2] - l2[2] : l1[1] - l2[1]) : l1[0] - l2[0]));
        
        inorder(root, pq, 0, 0);
        List<List<Integer>> list = new ArrayList<>();
        int prevVertical = pq.peek()[0];
        
        while(pq.size() != 0){
            List<Integer> l = new ArrayList<>();
            while(pq.size() != 0 && pq.peek()[0] == prevVertical){
                l.add(pq.poll()[2]);
            }
            
            list.add(l);
            if(pq.size() != 0) prevVertical = pq.peek()[0];
        }
        
        return list;
    }
    
    public void inorder(TreeNode root, PriorityQueue<int[]> pq, int level, int vertical){
        if(root == null) return;
        
        inorder(root.left, pq, level + 1, vertical - 1);
        
        int[] arr = {vertical, level, root.val};
        pq.add(arr);
        
        inorder(root.right, pq, level + 1, vertical + 1);
    }
}