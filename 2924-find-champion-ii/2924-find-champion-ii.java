class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];
        for(int i = 0; i < edges.length; i++){
            inDegree[edges[i][1]]++;
        }
        
        int res = -1;
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                if(res == -1) res = i;
                else return -1;
            }
        }
        
        return res;
    }
}