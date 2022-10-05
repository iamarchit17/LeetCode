class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] M = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '1') M[i][j] = 1;
                else M[i][j] = 0;
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(M[i][j] == 1) M[i][j] = M[i-1][j] + 1;
            }
        }
        
        int max = 0;
        for(int i = 0; i < m; i++){
            max = Math.max(max, largestRectangleArea(M[i]));
        }
        
        return max;
    }
    
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];

        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            while(!s.empty() && heights[s.peek()] >= heights[i]) s.pop();
            if(s.empty()) left[i] = -1;
            else left[i] = s.peek();
            s.push(i);
        }

        while(!s.empty()) s.pop();

        for(int i = heights.length - 1; i >= 0; i--){
            while(!s.empty() && heights[s.peek()] >= heights[i]) s.pop();
            if(s.empty()) right[i] = heights.length;
            else right[i] = s.peek();
            s.push(i);
        }

        int max = 0;
        for(int i = 0; i < heights.length; i++) max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);

        return max;
    }
}