//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution{
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X){
        
        Deque<Integer> dq = new ArrayDeque<>();
        int level = -1;
        dq.add(0);
        boolean[] visited = new boolean[V];
        visited[0] = true;
        int dist = 0;
        
        while(dq.size() != 0){
            int size = dq.size();
            for(int i = 0; i < size; i++){
                int node = dq.poll();
                if(node == X) {
                    level = dist;
                    break;
                }
                
                for(int nebr : adj.get(node)){
                    if(!visited[nebr]) {
                        visited[nebr] = true;
                        dq.add(nebr);
                    }
                }
            }
            dist++;
        }
        
        return level;
    }
}