// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int[] arr = new int[nums1.length + nums2.length];
        
//         int p = 0, q = 0;
        
//         for(int i = 0; i < arr.length; i++){
//             if(p < nums1.length && q < nums2.length){
//                 if(nums1[p] < nums2[q]){
//                     arr[i] = nums1[p];
//                     p++;
//                 } else {
//                     arr[i] = nums2[q];
//                     q++;
//                 }
//             } else if(p < nums1.length && q >= nums2.length){
//                 arr[i] = nums1[p++];
//             } else if (p >= nums1.length && q < nums2.length){
//                 arr[i] = nums2[q++];
//             }
//         }
        
//         if(arr.length % 2 == 0){
//             return (double) ((arr[arr.length/2] + arr[arr.length/2 - 1])/2.0);
//         }
        
//         return (double) arr[arr.length/2];
//     }
// }


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        
        int low = 0;
        int high = nums1.length;
        
        int totalNumbers = nums1.length + nums2.length;
        int leftArrayNums = totalNumbers % 2 == 0 ? totalNumbers/2 : totalNumbers/2 + 1;
        
        while(low <= high){
            int mid = (low + high)/2;
            
            int l1 = (mid == 0) ? Integer.MIN_VALUE : nums1[mid - 1];
            int l2 = (leftArrayNums - mid == 0) ? Integer.MIN_VALUE : nums2[leftArrayNums - mid - 1];
            int r1 = (mid == nums1.length) ? Integer.MAX_VALUE : nums1[mid];
            int r2 = (leftArrayNums - mid == nums2.length) ? Integer.MAX_VALUE : nums2[leftArrayNums - mid];
            
            if(l1 > r2){
                high = mid - 1;
            } else if(l2 > r1){
                low = mid + 1;
            } else {
                if(totalNumbers % 2 == 0) return (1.0 * (Math.max(l1, l2) + Math.min(r1, r2)))/2;
                else return 1.0 * Math.max(l1, l2);
            }
            
        }
        return -1.0;
    }
}















