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
class BSTIterator {
    Stack<Integer> s;
    
    public BSTIterator(TreeNode root) {
        s = new Stack<>();
        inorder(root, s);        
    }
    
    public void inorder(TreeNode root, Stack<Integer> s){
        if(root == null) return;
        inorder(root.right, s);
        s.push(root.val);
        inorder(root.left, s);
    }
    
    public int next() {
        return s.pop();
    }
    
    public boolean hasNext() {
        return s.size() != 0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */