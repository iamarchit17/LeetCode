class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder.equals("#")) return true;
        
        Deque<Integer> s = new ArrayDeque<>();
        
        for(int i = 0; i < preorder.length(); i++){
            int x = preorder.indexOf(',', i);
            
            String r = x == -1 ? preorder.substring(i, preorder.length()) : preorder.substring(i, x);

            if(r.equals("#")){
                if(s.isEmpty()) return false;
                else if(s.pop() == 2) s.push(1);
                
                if(s.isEmpty() && x != -1) return false;
            } else{
                if(!s.isEmpty() && s.pop() == 2) s.push(1);
                s.push(2);
            }

            i = x == -1 ? preorder.length() : x;
            
        }
        
        return s.size() == 0;
    }
}