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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        HashMap<Integer, Pair> map = new HashMap<>();
        map.put(root.val, new Pair(-1, 0));
        
        int level = 1;
        while(q.size() != 0){
            int size = q.size();
            for(int i = 0; i < size; i++){   
                TreeNode temp = q.poll();
                
                if(temp.left != null){
                    q.add(temp.left);
                    map.put(temp.left.val, new Pair(temp.val, level));
                }
                
                if(temp.right != null){
                    q.add(temp.right);
                    map.put(temp.right.val, new Pair(temp.val, level));
                }
            }
            
            level++;
        }
        
        if(map.get(x).parent != map.get(y).parent && map.get(x).level == map.get(y).level) return true;
        return false;
    }
}

class Pair{
    int parent, level;
    
    public Pair(int x, int y){
        this.parent = x;
        this.level = y;
    }
}