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

//Store Inorder Traversal
//TC: O(N), SC: O(N)
// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//         List<Integer> list = new ArrayList<>();
//         inorder(root, list);
        
//         int i = 0, j = list.size() - 1;
//         while(i < j){
//             if((list.get(i) + list.get(j)) == k) return true;
//             else if((list.get(i) + list.get(j)) < k) i++;
//             else j--;
//         }
        
//         return false;
//     }
    
//     public void inorder(TreeNode root, List<Integer> list){
//         if(root == null) return;
        
//         inorder(root.left, list);
//         list.add(root.val);
//         inorder(root.right, list);
//     }
// }


class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator bsti = new BSTIterator(root); 
        int x = bsti.next();
        int y = bsti.prev();
        
        while(x < y){
            if(x + y == k) return true;
            else if(x + y < k) x = bsti.next();
            else y = bsti.prev();
        }
        
        return false;
    }
}

class BSTIterator{
    Stack<TreeNode> s1, s2;
    
    public BSTIterator(TreeNode root){
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
        
        TreeNode temp = root;
        while(temp != null){
            s1.push(temp);
            temp = temp.left;
        }
        
        while(root != null){
            s2.push(root);
            root = root.right;
        }
    }
    
    public int next(){
        int x = s1.peek().val;
        TreeNode temp = s1.pop().right;
        while(temp != null){
            s1.push(temp);
            temp = temp.left;
        }
        
        return x;
    }
    
    public int prev(){
        int x = s2.peek().val;
        TreeNode temp = s2.pop().left;
        while(temp != null){
            s2.push(temp);
            temp = temp.right;
        }
        return x;
    }
}