class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int totalSum = 0;
        for(int i = 0; i < cardPoints.length; i++) totalSum += cardPoints[i];
        int size = cardPoints.length - k;
        
        if(size == 0) return totalSum;
        
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < size - 1; i++) sum += cardPoints[i];
        
        for(int i = size - 1; i < cardPoints.length; i++){
            sum += cardPoints[i];
            
            if(sum < minSum) minSum = sum;
            
            sum -= cardPoints[i - size + 1];
        }
        
    
        
        return totalSum - minSum;
    }
}