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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> listP = new ArrayList<>();
        ArrayList<TreeNode> listQ = new ArrayList<>();
        
        rootToNode(root, p, listP);
        rootToNode(root, q, listQ);
        
        HashSet<TreeNode> set = new HashSet<>();
        for(TreeNode i : listP) set.add(i);
        
        for(int i = listQ.size() - 1; i >= 0; i--){
            if(set.contains(listQ.get(i))) return listQ.get(i);
        }
        
        return null;
    }
    
    public boolean rootToNode(TreeNode root, TreeNode p, ArrayList<TreeNode> list){
        if(root == null) return false;
        
        list.add(root);
        if(root.val == p.val) return true;
        boolean x = rootToNode(root.left, p, list);
        boolean y = rootToNode(root.right, p, list);
        
        if(!(x || y)) list.remove(list.size() - 1);
        return x || y;
    }
}