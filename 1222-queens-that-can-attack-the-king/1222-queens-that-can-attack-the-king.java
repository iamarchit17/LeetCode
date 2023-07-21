class Solution {
   
    
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {    
        int[][] dir = new int[3][3];
        for(int i = 0; i < 3; i++) Arrays.fill(dir[i], -1);
        
        
        for(int i = 0; i < queens.length; i++){
            int x = queens[i][0] - king[0];
            int y = queens[i][1] - king[1];
            
            if(x == 0 || y == 0 || Math.abs(x) == Math.abs(y)){
                int mag = 0;
                if(x == 0){
                    mag = Math.abs(y);
                    y = y/mag;
                }
                else if(y == 0) {
                    mag = Math.abs(x);
                    x = x/Math.abs(x);
                }
                else{
                    mag = Math.abs(x);
                    x = x/mag;
                    y = y/mag;
                }
                
                x = x + 1;
                y = y + 1;
                if(dir[x][y] != -1){
                    int idx = dir[x][y];
                    int newMag = Math.max(Math.abs(queens[idx][0] - king[0]), Math.abs(queens[idx][1]- king[1]));
                    if(mag < newMag) dir[x][y] = i;
                } else {
                    dir[x][y] = i;
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(dir[i][j] != -1){
                    List<Integer> l = new ArrayList<>();
                    l.add(queens[dir[i][j]][0]);
                    l.add(queens[dir[i][j]][1]);
                    ans.add(l);
                }
            }
        }
        
        return ans;
    }
}