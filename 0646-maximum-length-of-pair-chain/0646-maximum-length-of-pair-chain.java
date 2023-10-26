class Solution {
    public int findLongestChain(int[][] pairs) {
        int count = 1;
        Arrays.sort(pairs, (l1, l2) -> l1[1] - l2[1]);
        int last = pairs[0][1]; 
        
        for(int i = 1; i < pairs.length; i++){
            if(pairs[i][0] > last){
                count++;
                last = pairs[i][1];
            } 
        }
        
        
        return count;
    }
}