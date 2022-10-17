/*
class Solution {
    public int longestOnes(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) sum += nums[i];
        if(sum == 0 && k == 0) return 0;
        
        int i = 0, j = 0, count = 0;
        int maxLen = -1;
        
        while(j < nums.length){
            if(nums[j] == 0) count++;
            
            while(count > k && i < j){
                if(nums[i] == 0) count--;
                i++;
            }
            
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }
        
        return maxLen;
    }
}
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
       int i = 0, j = 0;
       for(; j < nums.length; j++){
           if(nums[j] == 0) k--;
           if(k < 0){
               if(nums[i] == 0) k++;
               i++;
           }
       }
        
       return j - i; 
    }
}