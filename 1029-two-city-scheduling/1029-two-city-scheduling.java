class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (l1, l2) -> (l2[1] - l2[0]) - (l1[1] - l1[0]));
        int cost = 0;
        for(int i = 0; i < costs.length/2; i++){
            cost += costs[i][0];
        }
        
        for(int i = costs.length/2; i < costs.length; i++){
            cost += costs[i][1];
        }
        
        return cost;
    }
}