//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n){
        int[][] timings = new int[start.length][2];
        for(int i = 0; i < timings.length; i++){
            timings[i][0] = start[i];
            timings[i][1] = end[i];
        }
        
        Arrays.sort(timings, (l1, l2) -> l1[0] - l2[0]);
        
        int maxMeets = 1;
        int s = timings[0][0];
        int e = timings[0][1];
        
        for(int i = 1; i < timings.length; i++){
            if(timings[i][0] > e){
                maxMeets++;
                s = timings[i][0];
                e = timings[i][1];
            } else if(timings[i][1] < e){
                s = timings[i][0];
                e = timings[i][1];
            }
        }
        
        return maxMeets;
    }
}
