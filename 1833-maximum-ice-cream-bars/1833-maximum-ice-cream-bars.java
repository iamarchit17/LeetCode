class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0;
        int i = 0;
        for(; i < costs.length; i++){
            sum += costs[i];
            if(sum > coins) break;
        }
        
        return i;
    }
}