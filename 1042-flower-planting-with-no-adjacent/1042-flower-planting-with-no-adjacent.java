class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i < paths.length; i++){
            adj.get(paths[i][0]).add(paths[i][1]);
            adj.get(paths[i][1]).add(paths[i][0]);
        }
        
        int[] flower = new int[n];
        Arrays.fill(flower, -1);
        
        for(int i = 1; i < n+1; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int nbr : adj.get(i)){
                if(flower[nbr-1] != -1) set.add(flower[nbr-1]);
            }
            
            if(set.size() == 0) flower[i-1] = 1;
            else{
                for(int j = 1; j <= 4; j++){
                    if(!set.contains(j)){
                        flower[i-1] = j;
                        break;
                    }
                }
            }
        }
        
        return flower;
    }
}