class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        if(m == 0){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        
        
        for(int i = m - 1; i >= 0; i--) nums1[n + i] = nums1[i];
        
        int i = n;
        int j = 0;
        int idx = 0;
        while(i < m + n && j < n){
            if(nums1[i] < nums2[j]){
                nums1[idx] = nums1[i];
                i++;
            } else {
                nums1[idx] = nums2[j];
                j++;
            }
            
            idx++;
        }
        
        while(j < n) nums1[idx++] = nums2[j++];
    }
}