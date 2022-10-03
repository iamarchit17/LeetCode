class Solution {
    public String removeOuterParentheses(String s) {
        int opener = 0;
        String r = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                if(opener != 0) r += '(';
                opener++;
            } else {
                if(opener != 1) r += ')';
                opener--;
            }
        }
        return r;
    }
}

