class Solution {
    public int minOperations(String s) {
        int min = 0;
        int ops = 0;
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 0){
                if(s.charAt(i) == '1') ops++;
            } else{
                if(s.charAt(i) == '0') ops++;
            }
        }
        
        min = ops;
        ops = 0;
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 0){
                if(s.charAt(i) == '0') ops++;
            } else{
                if(s.charAt(i) == '1') ops++;
            }
        }
        
        return Math.min(min, ops);
    }
}