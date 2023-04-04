class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);        
        int minCost = 0;
        
        int j = 0;
        for(int i = cost.length - 1; i >= 0; i--){
            if(j == 2){
                j = 0;
                continue;
            }
            
            minCost += cost[i];
            j++;
        }
        
        return minCost;
    }
}