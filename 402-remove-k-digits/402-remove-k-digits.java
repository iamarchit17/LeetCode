class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            while(k > 0 && !st.empty() && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            
            st.push(num.charAt(i));
        }
        
        while(k-- > 0) st.pop();
        
        StringBuilder sb = new StringBuilder();
        while(!st.empty()) sb.append(st.pop());
        sb.reverse();
        while(sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        
        if(sb.length() == 0) return "0";
        else return sb.toString();
    }
}