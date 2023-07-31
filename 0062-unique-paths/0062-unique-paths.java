class Solution {
    public int uniquePaths(int m, int n) {
        int x = m + n - 2;
        int y = Math.min(n-1, m-1);
        
        long ans = 1;
        for(int i = 0; i < y; i++){
            ans = ans * (x - i);
            ans = ans / (i + 1);
        }
        
        return (int) ans;
    }
}