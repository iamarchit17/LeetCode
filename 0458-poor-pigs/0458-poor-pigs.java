class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int t = minutesToTest/minutesToDie;
        
        int p = 1;
        int x = 0;
        while(p < buckets){
            x++;
            p = (t+1) * p;
        }
        
        return x;
    }
}