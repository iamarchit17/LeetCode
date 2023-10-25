//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s1 = br.readLine().trim().split(" ");
            int[] height = new int[n];
            for(int i = 0; i < n; i++){
                height[i] = Integer.parseInt(s1[i]);
            }
            String[] s2 = br.readLine().trim().split(" ");
            int[] width = new int[n];
            for(int i = 0; i < n; i++){
                width[i] = Integer.parseInt(s2[i]);
            }
            String[] s3 = br.readLine().trim().split(" ");
            int[] length = new int[n];
            for(int i = 0; i < n; i++){
                length[i] = Integer.parseInt(s3[i]);
            }
            Solution obj = new Solution();
            System.out.println(obj.maxHeight(height, width, length, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        int[][] boxes = new int[n*3][3];
        for(int i = 0; i < n; i++){
            boxes[i*3 + 0][0] = height[i];
            boxes[i*3 + 0][1] = width[i];
            boxes[i*3 + 0][2] = length[i];
            
            boxes[i*3 + 1][0] = length[i];
            boxes[i*3 + 1][1] = height[i];
            boxes[i*3 + 1][2] = width[i];
            
            boxes[i*3 + 2][0] = width[i];
            boxes[i*3 + 2][1] = length[i];
            boxes[i*3 + 2][2] = height[i];
        }
        
        
        Arrays.sort(boxes, (l1, l2) -> (l2[0] * l2[1]) - (l1[0] * l1[1]));
        
        
        
        int[] dp = new int[3*n];
        for(int i = 0; i < 3*n; i++) dp[i] = boxes[i][2];
        
        for(int i = 1; i < 3*n; i++){
            for(int j = 0; j < i; j++){
                if((boxes[j][0] > boxes[i][0]) && (boxes[j][1] > boxes[i][1])){
                    if(dp[j] + boxes[i][2] > dp[i]){
                        dp[i] = dp[j] + boxes[i][2];
                    }
                } else if((boxes[j][0] > boxes[i][1]) && (boxes[j][1] > boxes[i][0])){
                    if(dp[j] + boxes[i][2] > dp[i]){
                        dp[i] = dp[j] + boxes[i][2];
                    }
                }
            }
        }
        
        int max = dp[0];
        for(int i : dp) {
            if(i > max) max = i;
        }
        return max;
    }
}