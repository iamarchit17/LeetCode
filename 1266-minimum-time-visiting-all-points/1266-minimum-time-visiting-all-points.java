class Solution {
    /*
    //wrong answer
    public int minTimeToVisitAllPoints(int[][] points) {
        /*
        //wrong answer
        int totalTime = 0;
        
        for(int i = 1; i < points.length; i++){
            
            if(points[i][0] == points[i - 1][0]){
                totalTime += Math.abs(points[i][1] - points[i - 1][1]);
            } else if(points[i][1] == points[i - 1][1]){
                totalTime += Math.abs(points[i][0] - points[i - 1][0]);
            } else{
                int p = Math.abs(points[i][0] - points[i - 1][0]);
                int q = Math.abs(points[i][1] - points[i - 1][1]);
                if(p < q){
                    totalTime += p;
                    int k = 0;
                    if(points[i][0] > points[i - 1][0]){
                        k = points[i - 1][1] + p;
                    } else {
                        k = points[i - 1][1] - p;
                    }
                    
                    totalTime += Math.abs(points[i][1] - k);
                } else {
                    totalTime += q;
                    int k = 0;
                    if(points[i][1]> points[i - 1][1]){
                        k = points[i - 1][0]+ q;
                    } else {
                        k = points[i - 1][0]- q;
                    }
                    
                    totalTime += Math.abs(points[i][0]- k);
                }
            }
            
        
        }
        return totalTime;
        
    }
    */
    
    public int minTimeToVisitAllPoints(int[][] points) {
        
        int totalTime = 0;
        
        for(int i = 1; i < points.length; i++){
            
            if(points[i][0] == points[i - 1][0]){
                totalTime += Math.abs(points[i][1] - points[i - 1][1]);
            } else if(points[i][1] == points[i - 1][1]){
                totalTime += Math.abs(points[i][0] - points[i - 1][0]);
            } else {
                int p = Math.abs(points[i][0] - points[i - 1][0]);
                int q = Math.abs(points[i][1] - points[i - 1][1]);
                
                totalTime += Math.max(p, q);
            }
        }
        return totalTime;
    }
}