class Solution {
    public int minFlips(String target) {
        int ops = 0;
        for(int i = 0; i < target.length(); i++){
            char c = (ops % 2 == 0) ? '0' : '1';
            if(target.charAt(i) != c) ops++;
        }
        
        return ops;
    }
}