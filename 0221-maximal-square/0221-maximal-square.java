class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] arr = new int[n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0) arr[j] = matrix[i][j] == '0' ? 0 : 1;
                else arr[j] = matrix[i][j] == '0' ? 0 : arr[j] + 1;
            }
            
            res = Math.max(res, maximalSquare(arr));
        }
        
        return res * res;
    }
    
    public int maximalSquare(int[] arr){
        int n = arr.length;
        int[] width = new int[n];
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = n - 1; i >= 0; i--){
            while(dq.size() != 0 && arr[dq.peek()] >= arr[i]) dq.pop();
            width[i] = dq.size() == 0 ? n : dq.peek();
            dq.push(i);
        }
        
        dq.clear();
        
        for(int i = 0; i < n; i++){
            while(dq.size() != 0 && arr[dq.peek()] >= arr[i]) dq.pop();
            width[i] = dq.size() == 0 ? width[i] : width[i] - dq.peek() - 1;
            dq.push(i);
        }
        
        int max = 0;
        for(int i = 0; i < n ; i++) max = Math.max(max, Math.min(width[i], arr[i]));
        return max;
    }
}