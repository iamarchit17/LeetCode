class Solution {
    public double myPow(double x, int n) {
        
        double res = 1.0;
        int temp = n;
        double tempX = x;
        int flag = 0;
        int sign = n < 0 ? -1 : 1;
        n = n == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(n);
        while(n > 0){
            if((n & 1) == 1) res = sign == -1 ? (res * 1.0)/x : res * x;
            x *= x;
            n = n >> 1;
        }
        
        if(temp == Integer.MIN_VALUE) res = sign == -1 ? (res * 1.0)/tempX : res * tempX;
        
        
        return res;
    }
}