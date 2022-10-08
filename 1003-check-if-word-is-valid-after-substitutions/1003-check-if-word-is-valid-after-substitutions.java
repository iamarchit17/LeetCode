class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != 'c') st.push(s.charAt(i));
            else{
                if(st.size() != 0 && st.peek() == 'b') st.pop();
                else return false;
                
                if(st.size() != 0 && st.peek() == 'a') st.pop();
                else return false;
            }
        }
        
        return st.size() == 0;
    }
}