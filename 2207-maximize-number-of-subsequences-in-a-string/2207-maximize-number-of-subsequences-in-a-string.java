class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
       
        char first = pattern.charAt(0), second = pattern.charAt(1);
        int firstFeq = 0; int secondFeq = 0;
        
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == first) firstFeq++;
            if(text.charAt(i) == second) secondFeq++;
        }
        
        long patterns = 0; int temp = secondFeq;
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == first) patterns += (first == second ? temp - 1 : temp);
            if(text.charAt(i) == second) temp--;
        }
        
        return patterns + Math.max(firstFeq, secondFeq);
    }
}