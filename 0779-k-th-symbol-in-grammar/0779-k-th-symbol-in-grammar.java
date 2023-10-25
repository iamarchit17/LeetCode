class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;
        boolean revert = false;
        
        int x = 1;
        for(int i = 1; i < n; i++) x *= 2;
        
        while(x != 1){
            if((k - (x/2)) > 0){
                k -= (x/2);
                revert = (!revert);
            }
            x /= 2;
        }
        
        return revert ? 1 : 0;
    }
}


//0
//01
//0110
//01101001
//01101001 10010110