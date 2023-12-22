class Solution {
    public int maxScore(String s) {
        int ones = 0;
        
        for(int i = 0; i < s.length(); i++) ones += (s.charAt(i) - 48);
        
        int zeroes = 0;
        
        int max = 0;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '1'){
                ones--;
            } else {
                zeroes++;
            }
            
            max = Math.max(max, ones + zeroes);
        }
        
        return max;
    }
}