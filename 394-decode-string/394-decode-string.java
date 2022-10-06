class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            if(x != ']') st.push(Character.toString(x));
            else{
                StringBuilder sb = new StringBuilder();
                while(!st.peek().equals("[")) sb.insert(0, st.pop());
                st.pop();
                String r = "";
                while(!st.empty() && (st.peek().charAt(0) > 47 && st.peek().charAt(0) < 58)) r = st.pop() + r;
                int p = Integer.parseInt(r);
                StringBuilder res = new StringBuilder();
                for(int j = 0; j < p; j++) res.append(sb.toString());
                st.push(res.toString());
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(!st.empty()) res.insert(0, st.pop());
        return res.toString();
    }
}