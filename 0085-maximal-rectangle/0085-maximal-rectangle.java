class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] arr = new int[n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0){
                    arr[j] = matrix[i][j] == '0' ? 0 : 1;
                } else {
                    arr[j] = matrix[i][j] == '0' ? 0 : arr[j] + 1;
                }
            }
            
            res = Math.max(res, maxHistogram(arr));
        }
        
        return res;
    }
    
    public int maxHistogram(int[] arr){
        int[] width = new int[arr.length];
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int i = arr.length - 1; i >= 0; i--){
            while(dq.size() != 0 && arr[dq.peek()] >= arr[i]) dq.pop();
            width[i] = dq.size() == 0 ? arr.length : dq.peek();
            dq.push(i);
        }
        
        dq.clear();
        
        for(int i = 0; i < arr.length; i++){
            while(dq.size() != 0 && arr[dq.peek()] >= arr[i]) dq.pop();
            width[i] = dq.size() == 0 ? width[i] : width[i] - dq.peek() - 1;
            dq.push(i);
        }
        
        int largest = 0;
        for(int i = 0; i < arr.length; i++) largest = Math.max(largest, arr[i] * width[i]);
        return largest;
    }
}