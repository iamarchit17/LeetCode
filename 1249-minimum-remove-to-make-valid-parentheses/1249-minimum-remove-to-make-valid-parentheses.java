class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int opener = 0;
        
        int closer = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')') closer++;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' && closer > 0){
                closer--;
                opener++;
                sb.append('(');
            } else if(s.charAt(i) == ')'){
                if(opener > 0){
                    sb.append(')');
                    opener--;
                } else closer--;

            } else if(s.charAt(i) != '(' && s.charAt(i) != ')'){
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}