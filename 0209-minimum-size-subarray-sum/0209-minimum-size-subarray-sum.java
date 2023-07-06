class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int j = 0;
        int minLen = nums.length + 1;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];

            while(sum >= target){
                minLen = Math.min(minLen, i - j + 1);
                sum = sum - nums[j++];
            }
        }

        return minLen == nums.length + 1 ? 0 : minLen;
    }
}