class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time = 0;
        
        int s = neededTime[0];
        int maxTime = neededTime[0];
        
        for(int i = 1; i < colors.length() ; i++){
            
            if(colors.charAt(i) == colors.charAt(i - 1)){
                maxTime = Math.max(maxTime, neededTime[i]);
                s += neededTime[i];
            } else {
                time += (s - maxTime);
                s = neededTime[i];
                maxTime = neededTime[i];
            }
        }
        
        return time + s - maxTime;
    }
}