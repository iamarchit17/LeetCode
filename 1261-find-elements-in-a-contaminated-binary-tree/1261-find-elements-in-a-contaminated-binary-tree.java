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

//1059 ms
// constructor takes O(N) time
//find function takes O(N) time
// class FindElements {
//     TreeNode root;
    
//     public FindElements(TreeNode base) {
//         this.root = base;
                
//         root.val = 0;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);

//         while(q.size() != 0){
//             TreeNode temp = q.poll();
            
//             if(temp.left != null){
//                 temp.left.val = 2 * temp.val + 1;
//                 q.add(temp.left);
//             }
            
//             if(temp.right != null){
//                 temp.right.val = 2 * temp.val + 2;
//                 q.add(temp.right);
//             }
//         }
//     }
    
//     public boolean find(int target) {
//         TreeNode temp = this.root;
//         return postorder(temp, target);
//     }
    
//     public boolean postorder(TreeNode root, int target){
//         if(root == null) return false;
        
//         boolean x = postorder(root.left, target);
//         boolean y = postorder(root.right, target);
        
//         return x || y || (root.val == target);
        
//     }
// }

class FindElements {
    HashSet<Integer> set;
    
    public FindElements(TreeNode root) {
        this.set = new HashSet<>();
                
        root.val = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size() != 0){
            TreeNode temp = q.poll();
            set.add(temp.val);
            if(temp.left != null){
                temp.left.val = 2 * temp.val + 1;
                q.add(temp.left);
            }
            
            if(temp.right != null){
                temp.right.val = 2 * temp.val + 2;
                q.add(temp.right);
            }
        }
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
    
    
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */