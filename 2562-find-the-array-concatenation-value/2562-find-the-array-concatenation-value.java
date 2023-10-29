class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        
        int i, j;
        for(i = 0, j = nums.length - 1; i < j; i++, j--){
            int pow = String.valueOf(nums[j]).length();
            
            long x = nums[i];
            for(int k = 0; k < pow; k++) x *= 10;
            
            x += nums[j];
            ans += x;
        }
        
        if(i == j) ans += nums[j];
        
        return ans;
    }
}