class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int surplus = 0;
        
        int res = 0;
        for(int i = 0; i < gas.length; i++){
            totalSurplus += (gas[i] - cost[i]);
            surplus += (gas[i] - cost[i]);
            if(surplus < 0){
                res = i + 1;
                surplus = 0;
            }
        }
        
        return totalSurplus >= 0 ? res : -1;
    }
}