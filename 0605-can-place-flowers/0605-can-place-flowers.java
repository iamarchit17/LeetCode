class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int last = -1;

        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 1){
                if(last == -1) n -= (i/2);
                else{
                    int x = i - last - 1;
                    n -= ((x - 1)/2);
                }
                last = i;
            } 
            
            if(n <= 0) return true;
        }
        
        if(last < flowerbed.length - 1){
            int x = flowerbed.length - 1 - last;
            n -= (x == flowerbed.length ? (x + 1)/2 : x/2);
        }
        
        return n <= 0;
    }
}