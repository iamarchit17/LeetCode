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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        map.put(root, null);
        
        TreeNode begin = null;
        
        while(dq.size() != 0){
            TreeNode temp = dq.poll();
            if(temp.left != null){
                map.put(temp.left, temp);
                dq.add(temp.left);
            }
            if(temp.right != null){
                map.put(temp.right, temp);
                dq.add(temp.right);
            }
            
            if(temp.val == start) begin = temp;
        }
        
        dq.clear();
        
        dq.add(begin);
        int time = -1;
        int count = 1;
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(begin);
        
        while(dq.size() != 0){
            count--;
            TreeNode temp = dq.poll();
            
            if(temp.left != null && !visited.contains(temp.left)){
                dq.add(temp.left);
                visited.add(temp.left);
            }
            if(temp.right != null && !visited.contains(temp.right)){
                dq.add(temp.right);
                visited.add(temp.right);
            }
            if(map.get(temp) != null && !visited.contains(map.get(temp))){
                dq.add(map.get(temp));
                visited.add(map.get(temp));
            }
                
            if(count == 0){
                count = dq.size();
                time++;
            }
        }
        
        return time;
    }
}