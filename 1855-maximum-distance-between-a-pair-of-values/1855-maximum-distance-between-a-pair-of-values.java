class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        
        int i = 0;
        for(int j = 0; j < nums2.length; j++){
            for(; i <= j && i < nums1.length; i++){
                if(nums1[i] <= nums2[j]){
                    max = Math.max(max, j - i);
                    break;
                } 
            }
        }
        
        return max;
    }
}