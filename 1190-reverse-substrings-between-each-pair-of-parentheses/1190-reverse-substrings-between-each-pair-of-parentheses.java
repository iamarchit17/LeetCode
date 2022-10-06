class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ')'){
                st.push(Character.toString(s.charAt(i)));
            } else{
                StringBuilder sb = new StringBuilder();
                while(!st.empty() && !st.peek().equals("(")) sb.append(st.pop());
                st.pop();
                if(i == s.length() - 1) st.push(sb.reverse().toString());
                else st.push(sb.reverse().toString());
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(!st.empty()) sb.append(st.pop());
        return sb.reverse().toString();
    }
}