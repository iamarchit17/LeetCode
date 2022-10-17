class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
    
        int temp = k;
        
        int i = 0, j = 0;
        for(; j < answerKey.length(); j++){
            if(answerKey.charAt(j) == 'F') temp--;
            if(temp < 0 && answerKey.charAt(i++) == 'F') temp++;
        }
        
        int setTrue = j - i;
        temp = k;
        i = 0;
        for(j = 0; j < answerKey.length(); j++){
            if(answerKey.charAt(j) == 'T') temp--;
            if(temp < 0 && answerKey.charAt(i++) == 'T') temp++;
        }
        
        int setFalse = j - i;
        
        return Math.max(setTrue, setFalse);
    }
}