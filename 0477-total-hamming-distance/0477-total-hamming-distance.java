class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] count = new int[31];
        
        for(int i = 0; i < 31; i++){
            for(int j = 0; j < nums.length; j++){
                if(((nums[j] >> i) & 1) == 1) count[i]++;
            }
        }
        
        int res = 0;
        for(int i = 0; i < 31; i++){
            res += (nums.length - count[i]) * (count[i]);
        }
        
        return res;
    }
}
