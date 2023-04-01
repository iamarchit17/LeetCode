/*
class Solution {
    public int minOperations(int[] nums) {
        int addOps = 0;
        int multOps = 0;
        
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            int[] arr = new int[2];
            while(temp > 0){
                if(temp % 2 == 1){
                    arr[0]++;
                    temp--;
                } else{
                    arr[1]++;
                    temp = temp >> 1;
                }
            }
            
            addOps += arr[0];
            multOps = Math.max(multOps, arr[1]);
        }
        
        return addOps + multOps;
    }
}
*/

class Solution {
    public int minOperations(int[] nums) {
        int addOps = 0;
        int multOps = 0;
        
        for(int bit = 0; bit <= 30; bit++){
            for(int i = 0; i < nums.length; i++){
                if((nums[i] & (1 << bit)) != 0){
                    addOps++;
                    multOps = bit;
                }
            }
        }
        return addOps + multOps;
    }
}
