class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        
        int p = 0, q = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(p < nums1.length && q < nums2.length){
                if(nums1[p] < nums2[q]){
                    arr[i] = nums1[p];
                    p++;
                } else {
                    arr[i] = nums2[q];
                    q++;
                }
            } else if(p < nums1.length && q >= nums2.length){
                arr[i] = nums1[p++];
            } else if (p >= nums1.length && q < nums2.length){
                arr[i] = nums2[q++];
            }
        }
        
        if(arr.length % 2 == 0){
            return (double) ((arr[arr.length/2] + arr[arr.length/2 - 1])/2.0);
        }
        
        return (double) arr[arr.length/2];
    }
}