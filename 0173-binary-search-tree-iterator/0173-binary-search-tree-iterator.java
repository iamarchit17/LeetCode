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
    Stack<TreeNode> s;
    
    public BSTIterator(TreeNode root) {
        this.s = new Stack<>();
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        int x = s.peek().val;
        TreeNode temp = s.pop();
        temp = temp.right;
        while(temp != null){
            s.push(temp);
            temp = temp.left;
        }
        
        return x;
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