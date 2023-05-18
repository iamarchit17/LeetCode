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
    public int minimumOperations(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int levelSize = 1;
        int ops = 0;
        
        while(q.size() != 0){
            int[] arr = new int[levelSize];
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < levelSize; i++){
                TreeNode temp = q.poll();
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                
                map.put(temp.val, i);
                arr[i] = temp.val;
            }
            
            int[] sortedArr = arr.clone();
            Arrays.sort(sortedArr);
            
            for(int i = 0; i < levelSize; i++){
                if(map.get(sortedArr[i]) != i){
                    int tempIndex = map.get(sortedArr[i]);
                    map.put(sortedArr[i], i);
                    int tempVal = arr[i];
                    arr[i] = sortedArr[i];
                    map.put(tempVal, tempIndex);
                    arr[tempIndex] = tempVal;
                    ops++;
                    
                }
            }
            
            
            levelSize = q.size();
        }
        
        return ops;
    }
}