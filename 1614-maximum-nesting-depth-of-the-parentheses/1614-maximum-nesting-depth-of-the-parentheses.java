class Solution {
    public int maxDepth(String s) {
        int opener = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') opener++;
            else if(s.charAt(i) == ')') opener--;
            if(opener > max) max = opener;
        }
        
        return max;
    }
}