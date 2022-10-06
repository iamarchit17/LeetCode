class Solution {
    public String smallestNumber(String pattern) {
        int num = 0;
        int max = 0;
        
        for(int i = 0; i < pattern.length(); i++){
            if(pattern.charAt(i) == 'I'){
                max++;
                num = num * 10 + max;
            } else {
                int count = 0;
                for(; i < pattern.length(); i++){
                    if(pattern.charAt(i) == 'D') count++;
                    else break;
                }
                
                for(int j = count; j >= 0; j--){
                    num = num * 10 + (max + j + 1);
                }
                
                max = max + count + 1;
            }
        }
        
        if(pattern.charAt(pattern.length() - 1) == 'I') num = num * 10 + (max + 1);
        return Integer.toString(num);
    }
}