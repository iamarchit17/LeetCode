class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] res = new int[n][m];
        for(int i = 0; i < n; i++) Arrays.fill(res[i], -1);
        
        Deque<Pair> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    dq.add(new Pair(i, j));
                    res[i][j] = 0;
                }
            }
        }
        
        int dist = 1;
        while(dq.size() != 0){
            int size = dq.size();
            for(int i = 0; i < size; i++){
                Pair p = dq.poll();
                int x = p.x;
                int y = p.y;
                
                if(x-1 >= 0 && mat[x-1][y] == 1 && res[x-1][y] == -1){
                    dq.add(new Pair(x-1, y));
                    res[x-1][y] = dist;
                    
                }
                
                if(x+1 < n && mat[x+1][y] == 1 && res[x+1][y] == -1){
                    dq.add(new Pair(x+1, y));
                    res[x+1][y] = dist;
                    
                }
                
                if(y-1 >= 0 && mat[x][y-1] == 1 && res[x][y-1] == -1){
                    dq.add(new Pair(x, y-1));
                    res[x][y-1] = dist;
                    
                }
                
                if(y+1 < m && mat[x][y+1] == 1 && res[x][y+1] == -1){
                    dq.add(new Pair(x, y+1));
                    res[x][y+1] = dist;
                    
                }
            }
            dist++;
        }
        
        return res;
    }
}

class Pair{
    int x, y;
    
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}