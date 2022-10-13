class Solution {
    public int minimumRecolors(String blocks, int k) {
        int countB = 0;
        int countW = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < k-1; i++){
            if(blocks.charAt(i) == 'W') countW++;
            else countB++;
        }
        
        for(int i = k-1; i < blocks.length(); i++){
            if(blocks.charAt(i) == 'W') countW++;
            else countB++;
            
            min = Math.min(min, countW);
            
            if(blocks.charAt(i-k+1) == 'W') countW--;
            else countB--;
        }
        
        return min;
    }
}