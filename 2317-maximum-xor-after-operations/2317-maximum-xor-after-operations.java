// class Solution {
    
//     // since you can take AND of nums[i] with (nums[i] xor x)
//     //you cannot set a non-set bit in nums[i]
//     //however you can unset a bit in nums[i] by the given operation
//     //hence, if any bit is set in even number of numbers in nums, 
//     //you can choose any one number and unset that bit
//     //on xoring all the elements, it will contribute in maximizing xor of all numbers
//     public int maximumXOR(int[] nums) {
//         int res = 0;
//         for(int i = 0; i < 31; i++){
//             int count = 0;
//             for(int j = 0; j < nums.length; j++){
//                 if(((nums[j] >> i) & 1) == 1) count++;
//             }
            
//             if(count != 0){
//                 res = res | (1 << i);
//             }
//         }
        
//         return res;
//     }
// }

class Solution {
    
    //the code written above is simply ORing all the elements
    public int maximumXOR(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++){
           res = res | nums[i];
        }
        
        return res;
    }
}
