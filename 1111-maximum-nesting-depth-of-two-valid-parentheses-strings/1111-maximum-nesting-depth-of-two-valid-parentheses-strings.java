class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int[] res = new int[s.length()];
        int max = 0;
        int opener = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') {
                opener++;
                if(opener > max) max = opener;
            } else opener--;
        }
        
        max /= 2;
        opener = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                opener++;
                if(opener > max) res[i] = 1;
            } else {
                if(opener > max) res[i] = 1;
                opener--;
            }
        
        }
        
        return res;
    }
}