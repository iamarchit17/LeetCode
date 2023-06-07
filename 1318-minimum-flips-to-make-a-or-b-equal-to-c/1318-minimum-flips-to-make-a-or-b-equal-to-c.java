class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for(int i = 0; i < 30; i++){
            if(((c >> i) & 1) == 1){
                if((((a >> i) & 1)| ((b >> i) & 1)) == 0) ans++;
            } else {
                if(((a >> i) & 1) == 1) ans++;
                if(((b >> i) & 1) == 1) ans++;
            }
        }
        
        return ans;
    }
}