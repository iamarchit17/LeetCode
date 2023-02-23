//Top - Down Dynamic Programming
// class Solution {
//     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
//         int[][] arr = new int[capital.length][2];
        
//         for(int i = 0; i < capital.length; i++){
//             arr[i][0] = profits[i];
//             arr[i][1] = capital[i];
//         }
        
//         Arrays.sort(arr, (l1, l2) -> l2[1] - l1[1]);
//         for(int i = 0; i < arr.length; i++){
//             profits[i] = arr[i][0];
//             capital[i] = arr[i][1];
//             // System.out.println(profits[i] + " "  + capital[i]);
//         }
        
//         int[][] dp = new int[k+1][capital.length+1];
//         for(int i = 0; i < dp.length; i++) Arrays.fill(dp[i], -1);
//         for(int i = 0; i < dp.length; i++) dp[i][0] = w;
//         for(int i = 0; i < dp[0].length; i++) dp[0][i] = w;
        
//         return rec(k, w, profits, capital, capital.length, dp);
        
//     }
    
//     public int rec(int k, int w, int[] profits, int[] capital, int n, int[][] dp){
//         if(n == 0 || k == 0) return dp[k][n];
        
//         if(dp[k][n] != -1) return dp[k][n];
//         if(capital[n-1] > w) return dp[k][n] = rec(k, w, profits, capital, n - 1, dp);
        
//         else return dp[k][n] = Math.max(rec(k, w, profits, capital, n-1, dp), profits[n-1] + rec(k - 1, w + profits[n-1], profits, capital, n-1, dp));
//     }
// }


class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int[][] arr = new int[capital.length][2];
        
        for(int i = 0; i < capital.length; i++){
            arr[i][0] = profits[i];
            arr[i][1] = capital[i];
        }
        
        Arrays.sort(arr, (l1, l2) -> l1[1] - l2[1]);
        for(int i = 0; i < arr.length; i++){
            profits[i] = arr[i][0];
            capital[i] = arr[i][1];
            // System.out.println(profits[i] + " "  + capital[i]);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(capital.length, (l1, l2) -> (l2.a - l1.a) == 0 ? (l1.b - l2.b) : (l2.a - l1.a));
        
        int count = 0;
        
        for(int i = 0; i < capital.length;){
            while(i < capital.length && capital[i] <= w){
                Pair p = new Pair(profits[i], capital[i]);
                pq.add(p);
                i++;
            }
            
            
            
            if(pq.size() != 0){
                w += pq.poll().a;
                count++;
            } else i++;
            
            if(count == k) break;
        }
        
        while(pq.size() != 0 && count < k){
            w += pq.poll().a;
            count++;
        }
        
        return w;
    }
}

class Pair{
    int a, b;
    
    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
}