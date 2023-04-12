/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        
        HashMap<TreeNode, TreeNode> map = markParents(root);
        HashSet<TreeNode> visited = new HashSet<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(target);
        visited.add(target);
        int dist = 0;
        while(dist < k){
            dist++;
            int count = dq.size();
            for(int i = 0; i < count; i++){
                TreeNode temp = dq.poll();
                if(map.containsKey(temp) && !visited.contains(map.get(temp))){
                    visited.add(map.get(temp));
                    dq.add(map.get(temp));
                }

                if(temp.left != null && !visited.contains(temp.left)){
                    visited.add(temp.left);
                    dq.add(temp.left);
                }

                if(temp.right != null && !visited.contains(temp.right)){
                    visited.add(temp.right);
                    dq.add(temp.right);
                }
            }   
        }
        
        while(dq.size() != 0) list.add(dq.poll().val);
        
        return list;
    }
    
    public HashMap<TreeNode, TreeNode> markParents(TreeNode root){
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        if(root == null) return map;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        
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
        }
        
        return map;
    }
}