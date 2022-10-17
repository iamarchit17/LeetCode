class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] avg = new int[nums.length];
        Arrays.fill(avg, -1);
        
        int window = 2 * k + 1;
        
        int i = 0, j = 0;
        long sum = 0;
        while(j < nums.length){
            sum += (long) nums[j];
            
            if(j - i + 1 == window){
                avg[i+k] = (int) (sum/window);
                sum -= (long) nums[i];
                i++;
            }
            j++;
        }
        
        return avg;
    }
}