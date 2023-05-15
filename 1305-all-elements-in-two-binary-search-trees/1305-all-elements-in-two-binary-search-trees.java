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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        
        BSTIterator bsti1 = new BSTIterator(root1);
        BSTIterator bsti2 = new BSTIterator(root2);
        
        int x = bsti1.hasNext() ? bsti1.next() : Integer.MIN_VALUE;
        int y = bsti2.hasNext() ? bsti2.next() : Integer.MIN_VALUE;
        
        while(true){
            if(x != Integer.MIN_VALUE && y != Integer.MIN_VALUE){
                if(x < y){
                    list.add(x);
                    x = bsti1.hasNext() ? bsti1.next() : Integer.MIN_VALUE;
                } else {
                    list.add(y);
                    y = bsti2.hasNext() ? bsti2.next() : Integer.MIN_VALUE;
                }
            } else if(x == Integer.MIN_VALUE && y != Integer.MIN_VALUE){
                list.add(y);
                y = bsti2.hasNext() ? bsti2.next() : Integer.MIN_VALUE;
            } else if(x != Integer.MIN_VALUE && y == Integer.MIN_VALUE){
                list.add(x);
                x = bsti1.hasNext() ? bsti1.next() : Integer.MIN_VALUE;
            } else break;
        }
        
        return list;
    }
}

class BSTIterator{
    Stack<TreeNode> s;
    
    public BSTIterator(TreeNode root){
        this.s = new Stack<>();
        while(root != null){
            s.push(root);
            root = root.left;
        }
    }
    
    public int next(){
        int x = s.peek().val;
        TreeNode temp = s.pop().right;
        while(temp != null){
            s.push(temp);
            temp = temp.left;
        }
        
        return x;
    }
    
    public boolean hasNext(){
        return s.size() != 0;
    }
}