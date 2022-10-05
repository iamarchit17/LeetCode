class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0;
        int lvp = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') open++;
            else close++;
            
            if(open == close) lvp = Math.max(lvp, open+close);
            if(close > open) open = close = 0;
        }
        
        open = close = 0;
        
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == '(') open++;
            else close++;
            
            if(open == close) lvp = Math.max(lvp, open+close);
            if(open > close) open = close = 0;
        }
        
        return lvp;
    }
}