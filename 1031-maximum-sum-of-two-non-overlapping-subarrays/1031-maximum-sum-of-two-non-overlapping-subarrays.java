class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int f, int s) {
        int n = nums.length;
        int[] preSum = new int[n];
        
        for(int i = 0; i < n; i++){
            if(i == 0) preSum[i] = nums[i];
            else preSum[i] = preSum[i-1] + nums[i];
        }
        
        int maxF = preSum[f-1]; //for window of length f + s starting at index 0
        int maxSum1 = preSum[f+s-1]; 
        
        //in this loop, we are maintaing maximum sum of subarray of length f
        //and we are finding the subarray of length s, which begins after subarray of length f ends
        //such that sum of these two subarray's is maximum
        for(int i = 0; i < n-f-s; i++){
            maxF = Math.max(maxF, preSum[i+f] - preSum[i]); //calculating from window starting at index 1 (not 0)
            int sumS = preSum[i+f+s] - preSum[i+f]; //calculating sum of window of size s just after subarray of size f
            maxSum1 = Math.max(maxSum1, maxF + sumS);
        }
        
        int maxS = preSum[s-1];
        int maxSum2 = preSum[s+f-1];
        
        //in this loop, we are maintaing maximum sum of subarray of length s
        //and we are finding the subarray of length f, which begins after subarray of length s ends
        //such that sum of these two subarray's is maximum
        for(int i = 0; i < n-f-s; i++){
            maxS = Math.max(maxS, preSum[i+s] - preSum[i]); //calculating from window starting at index 1 (not 0)
            int sumF = preSum[i+f+s] - preSum[i+s]; //calculating sum of window of size s just after subarray of size f
            maxSum2 = Math.max(maxSum2, maxS + sumF);
        }
        
        return Math.max(maxSum1, maxSum2);
    }

}