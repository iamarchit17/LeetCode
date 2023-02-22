class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCap = 0;
        int maxCap = 0;
        
        for(int i : weights){
            if(i > minCap) minCap = i;
            maxCap += i;
        }
        
        while(minCap < maxCap){
            int mid = (minCap + (maxCap - minCap)/2), d = 1, currW = 0;
            
            for(int w : weights){
                if(currW + w > mid){
                    d += 1;
                    currW = 0;
                }
                
                currW += w;
            }
            
            if(d > days) minCap = mid + 1;
            else maxCap = mid;
        }
        
        return maxCap;
    }
}