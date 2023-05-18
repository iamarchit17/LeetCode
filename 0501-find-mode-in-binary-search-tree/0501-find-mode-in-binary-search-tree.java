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
    public int[] findMode(TreeNode root) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        findMode(root, map);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(map.size(), (l1, l2) -> l2.getValue() - l1.getValue());
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry);
        }
        
        int max = pq.peek().getValue();
        List<Integer> list = new ArrayList<>();
        while(pq.size() != 0 && pq.peek().getValue() == max){
            list.add(pq.poll().getKey());
        }
        
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
    
    public void findMode(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null) return;
        
        findMode(root.left, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        findMode(root.right, map);
    }
}