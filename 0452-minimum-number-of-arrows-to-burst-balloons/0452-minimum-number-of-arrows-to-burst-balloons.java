class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (l1, l2) -> (l1[0] < l2[0]) ? -1 : 1);
        
//         for(int i = 0; i < points.length; i++){
//             System.out.println(points[i][0] + " " + points[i][1]);
//         }
        
        int arrows = 1;
        int end = points[0][1];
        
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > end){
                arrows++;
                end = points[i][1];
            } else {
                if(points[i][1] < end) end = points[i][1];
            }
        }
        
        return arrows;
    }
}