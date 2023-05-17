/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        sb.append(String.valueOf(root.val));
        sb.append(",");
        
        while(dq.size() != 0){
            TreeNode temp = dq.poll();
            if(temp.left == null) sb.append("null");
            else{
                sb.append(String.valueOf(temp.left.val));
                dq.add(temp.left);
            } 
            sb.append(",");
            
            
            if(temp.right == null) sb.append("null"); 
            else{
                sb.append(String.valueOf(temp.right.val));
                dq.add(temp.right);
            }
            
            if(dq.size() != 0) sb.append(",");
        }
        
        return sb.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        int indexComma = data.indexOf(',');
        TreeNode root = new TreeNode(Integer.valueOf(data.substring(0, indexComma)));
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        
        while(dq.size() != 0){
            int size = dq.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = dq.poll();
                int beginIndex = indexComma + 1;
                indexComma = data.indexOf(',', beginIndex);
                
                if(data.substring(beginIndex, indexComma).equals("null")) temp.left = null;
                else {
                    temp.left = new TreeNode(Integer.valueOf(data.substring(beginIndex, indexComma)));
                    dq.add(temp.left);
                }
                
                beginIndex = indexComma + 1;
                indexComma = data.indexOf(',', beginIndex);
                if(indexComma == -1) indexComma = data.length();
                if(data.substring(beginIndex, indexComma).equals("null")) temp.right = null;
                else {
                    temp.right = new TreeNode(Integer.valueOf(data.substring(beginIndex, indexComma)));
                    dq.add(temp.right);
                }  
            }
        }
                
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;