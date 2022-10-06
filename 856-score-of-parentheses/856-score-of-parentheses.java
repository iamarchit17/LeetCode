class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0;
        int open = 0;
        int x = 0;
        boolean flag = false;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
                if(open == 1) x = 1;
                else x *= 2;
                flag = true;
            } else {
                open--;
                if(flag) score += x;
                flag = false;
                x /= 2;
            }
        }
        
        return score;
    }
}