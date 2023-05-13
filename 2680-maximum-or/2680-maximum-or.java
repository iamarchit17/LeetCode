class Solution {
    public long maximumOr(int[] nums, int k) {
        long max = 0;
        
        long or = nums[0];
        for(int i = 1; i < nums.length; i++) or = or | nums[i];
        
        int[] freq = new int[30];
        for(int i = 0; i < 30; i++){
            for(int j = 0; j < nums.length; j++){
                if(((nums[j] >> i) & 1) == 1) freq[i]++;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            long temp = or;
            for(int j = 0; j < 30; j++){
                if(freq[j] == 1 && ((nums[i] >> j) & 1) == 1){
                    temp = temp ^ (1 << j);
                }
            }
            
            long x = nums[i];
            temp = temp | (x << k);
            if(temp > max) max = temp;            
        }
        
        return max;
    }
}