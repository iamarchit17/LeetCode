//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        boolean[] res = new boolean[100000];
        
        Queue<Integer> q = new LinkedList<>();
        for(int i : arr) res[i] = true;
        q.add(start);
        
        res[start] = true;
        
        int dist = 0;
        while(q.size() != 0){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                int x = q.poll();
                
                if(x == end) return dist;
                for(int j : arr){
                    if(!res[(x*j)%100000]){
                        res[(x*j)%100000] = true;
                        q.add((x*j)%100000);
                    }
                }
            }
            dist++;
        }
        
        return -1;
    }
}
