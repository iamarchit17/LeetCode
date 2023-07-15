/*
//Recursive
class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (l1, l2) -> l1[0] - l2[0]);
        return maxValue(events, k, 0, 0);
        
    }
    
    public int maxValue(int[][] events, int k, int idx, int lastEndDay){
        if(idx == events.length || k == 0) return 0;
        
        if(events[idx][0] > lastEndDay){
            int s1 = events[idx][2] + maxValue(events, k-1, idx + 1, events[idx][1]);
            int s2 = maxValue(events, k, idx+1, lastEndDay);
            
            return Math.max(s1, s2);
        }
        
        return maxValue(events, k, idx+1, lastEndDay);
    }
}
*/

class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (l1, l2) -> l1[0] - l2[0]);
        int[][] dp = new int[k+1][events.length+1];
        for(int i = 0; i < k+1; i++) Arrays.fill(dp[i], -1);
        Arrays.fill(dp[0], 0);
        for(int i = 0; i < k+1; i++) dp[i][events.length] = 0;
        
        return maxValue(events, k, 0, 0, dp);
    }
    
    public int maxValue(int[][] events, int k, int idx, int lastEndDay, int[][] dp){
        if(idx == events.length || k == 0) return 0;
        
        if(events[idx][0] <= lastEndDay) return maxValue(events, k, idx+1, lastEndDay, dp); 
        if(dp[k][idx] != -1) return dp[k][idx];
        
        int s1 = events[idx][2] + maxValue(events, k-1, idx+1, events[idx][1], dp);
        int s2 = maxValue(events, k, idx+1, lastEndDay, dp);
        return dp[k][idx] = Math.max(s1, s2);
    }
}