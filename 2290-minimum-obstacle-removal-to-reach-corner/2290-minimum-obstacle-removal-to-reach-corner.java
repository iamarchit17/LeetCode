class Solution {
    private boolean isValid(int i, int j, int m, int n){
        return i >= 0 && j >= 0 && i < m && j < n;
    }
    
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        PriorityQueue<Triplet> pq = new PriorityQueue<>(m * n, (l1, l2) -> l1.r - l2.r);
        pq.add(new Triplet(0,0,0));
        
        int[][] obstacles = new int[m][n];
        for(int[] arr : obstacles) Arrays.fill(arr, Integer.MAX_VALUE);
        obstacles[0][0] = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while(pq.size() != 0){
            Triplet t = pq.poll();
            int x = t.x;
            int y = t.y;
            int r = t.r;
            
            for(int i = 0; i < 4; i++){
                int nrow = x + dx[i];
                int ncol = y + dy[i];
                
                if(isValid(nrow, ncol, m, n)){
                    int cr = grid[nrow][ncol] + r;
                    if(cr < obstacles[nrow][ncol]){
                        pq.add(new Triplet(nrow, ncol, cr));
                        obstacles[nrow][ncol] = cr;
                    }
                }
            }
        }
        
        return obstacles[m-1][n-1];
    }
}

class Triplet{
    int x, y, r;
    
    public Triplet(int x, int y, int r){
        this.x = x;
        this.y = y;
        this.r = r;
    }
}