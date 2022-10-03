class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(!st.empty() && Math.abs(s.charAt(i) - st.peek()) == 32) st.pop();
            else st.push(s.charAt(i));
        } 
        
        StringBuilder sb = new StringBuilder();
        while(!st.empty()) sb.append(st.pop());
        
        return sb.reverse().toString();
    }
}