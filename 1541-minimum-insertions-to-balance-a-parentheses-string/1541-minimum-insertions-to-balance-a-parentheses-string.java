class Solution {
    public int minInsertions(String s) {
        Deque<Character> st = new ArrayDeque<>();
        int minIns = 0;
        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            if(x == '(') st.push(x);
            else{
                if(st.isEmpty()){
                    st.push('(');
                    i--;
                    minIns++;
                } else {
                    if(i+1 < s.length() && s.charAt(i+1) == ')'){
                        i++;
                    } else {
                        minIns++;
                    }
                    st.pop();
                }
            }
        }
        
        return minIns + 2 * st.size();
    }
}