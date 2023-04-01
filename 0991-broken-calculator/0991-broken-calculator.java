class Solution {
    public int brokenCalc(int startValue, int target) {
        
        if(target <= startValue) return startValue - target;
        
        int ops = 0;
        while(target != startValue){
            if(target <= startValue) return ops + startValue - target;
            
            if(target % 2 == 0) target = target >> 1;
            else target++;
            ops++;
        }
        
        return ops;
    }
}