class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> st = new ArrayDeque<>();
        
        for(int i = 0; i < s.length(); i++){
            int x = s.charAt(i);
            if(st.isEmpty() || st.peek()[0] != x){
                int[] arr = {x, 1};
                st.push(arr);
            } else if(st.peek()[0] == x){
                if(st.peek()[1] == k-1) st.pop();
                else st.peek()[1]++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            int x = st.peek()[1];
            char c = (char)st.pop()[0];
            for(int i = 0; i < x; i++) sb.append(c);
        }
        
        return sb.reverse().toString();
    }
}