class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int s = 0, e = m-1;
        while(s <= e){
            int mid = s + (e - s)/2;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] < target) s = mid + 1;
            else e = mid - 1;
        }
        
        
        int row = s - 1;
        if(row == -1) return false;
        
        s = 0; e = n - 1;
        
        while(s <= e){
            int mid = s + (e - s)/2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] < target) s = mid + 1;
            else e = mid - 1;
        }
        
        return false;
    }
}