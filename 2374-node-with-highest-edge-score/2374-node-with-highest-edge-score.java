class Solution {
    public int edgeScore(int[] edges) {
        long[] score = new long[edges.length];
        for(int i = 0; i < edges.length; i++) score[edges[i]] += i;
        
        long max = -1;
        int node = -1;
        for(int i = 0; i < edges.length; i++){
            if(score[i] > max){
                max = score[i];
                node = i;
            }
        }
        
        return node;
    }
}