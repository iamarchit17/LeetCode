class Solution {
    public int minTimeToType(String word) {
        int minTime = 0;
        char ptr = 'a';
        
        for(int i = 0; i < word.length(); i++){
            int x = Math.abs(word.charAt(i) - ptr);
            minTime += (1 + Math.min(x, 26 - x));
            ptr = word.charAt(i);
        }
        
        return minTime;
    }
}