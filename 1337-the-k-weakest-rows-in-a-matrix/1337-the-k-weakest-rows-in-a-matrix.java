class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (l1, l2) -> (l2[0] - l1[0] == 0) ? l2[1] - l1[1] : l2[0] - l1[0]);
        
        for(int i = 0; i < mat.length; i++){
            int start = 0;
            int end = mat[0].length - 1;
            
            while(start <= end){
                int mid = start + (end - start)/2;
                
                if(mat[i][mid] == 1){
                    start = mid + 1;
                } else {
                    end = mid - 1;   
                }

            } 
            
            int[] arr = {end+1, i};

            if(pq.size() < k){
                pq.add(arr);
            } else {
                if(pq.peek()[0] > arr[0]){
                    pq.poll();
                    pq.add(arr);
                }
            }
            
        }
            
        int[] ans = new int[k];
        for(int i = k-1; i >= 0; i--){
            ans[i] = pq.poll()[1];
        }
            
        return ans;
    }
}