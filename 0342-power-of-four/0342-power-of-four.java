class Solution {
    public boolean isPowerOfFour(int n) {
        long i = 1;
        for(; i <= n; i *= 4){
            if(n == i) return true;
        }
        
        return false;
    }
}