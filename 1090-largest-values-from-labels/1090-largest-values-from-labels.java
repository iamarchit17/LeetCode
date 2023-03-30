class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int[][] mat = new int[values.length][2];
        for(int i = 0; i < values.length; i++){
            mat[i][0] = values[i];
            mat[i][1] = labels[i];
        }
        Arrays.sort(mat, (l1, l2) -> l2[0] - l1[0]);
        
        int score = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = 0;
        
        for(int i = 0; i < values.length; i++){
            if(map.containsKey(mat[i][1])){
                if(map.get(mat[i][1]) < useLimit){
                    score += mat[i][0];
                    map.replace(mat[i][1], map.get(mat[i][1]) + 1);
                    size++;
                }
            } else {
                map.put(mat[i][1], 1);
                score += mat[i][0];
                size++;
            }
            
            if(size == numWanted) break;
        }
        
        return score;
    }
}