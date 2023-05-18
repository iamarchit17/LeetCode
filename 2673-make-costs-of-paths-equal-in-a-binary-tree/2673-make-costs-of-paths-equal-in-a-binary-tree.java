
//DFS Solution
/*
class Solution {
    public int minIncrements(int n, int[] cost) {
        int[] ops = new int[1];
        minIncrements(n, cost, ops, 0);
        return ops[0];
    }
    
    public int minIncrements(int n, int[] cost, int[] ops, int index){
        if(index >= n) return 0;
        
        int x = minIncrements(n, cost, ops, 2 * index + 1);
        int y = minIncrements(n, cost, ops, 2 * index + 2);
        
        ops[0] += Math.abs(x - y);
        return cost[index] + Math.max(x, y);
    }
}
*/

class Solution {
    public int minIncrements(int n, int[] cost) {
        int ops = 0;
        for(int i = n/2 - 1; i >= 0; i--){
            ops += Math.abs(cost[2 * i + 1] - cost[2 * i + 2]);
            cost[i] += Math.max(cost[2 * i + 1], cost[2 * i + 2]);
        }
        
        return ops;
    }
}