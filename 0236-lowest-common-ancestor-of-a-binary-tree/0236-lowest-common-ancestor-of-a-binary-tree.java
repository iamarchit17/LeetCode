/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> listP = new ArrayList<>();
        ArrayList<TreeNode> listQ = new ArrayList<>();
        
        rootToNode(root, p, listP);
        rootToNode(root, q, listQ);
        
        for(int i = 1; i < listP.size() && i < listQ.size(); i++){
            if(listP.get(i).val != listQ.get(i).val) return listP.get(i - 1);
        }
          
        return listP.size() > listQ.size() ? listQ.get(listQ.size() - 1) : listP.get(listP.size() - 1);
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
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        if(root.val == p.val || root.val == q.val) return root;
        
        TreeNode x = lowestCommonAncestor(root.left, p, q);
        TreeNode y = lowestCommonAncestor(root.right, p, q);
        
        if(x != null && y != null) return root;
        else if(x == null) return y;
        else if(y == null) return x;
        
        return null;
    }
    
    
}