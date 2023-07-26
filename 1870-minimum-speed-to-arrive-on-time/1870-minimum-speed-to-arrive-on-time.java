class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 0;
        int high = 10000000;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isPossible(dist, hour, mid)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return ans;
    }
    
    public boolean isPossible(int[] dist, double hour, int speed){
        double time = 0.0;
        
        for(int i = 0; i < dist.length; i++){
            time += ((dist[i] * 1.0)/speed);
            if(i != dist.length - 1) time = Math.ceil(time);
            if(time > hour) return false;
        }
        
        return time <= hour;
    }
    
}