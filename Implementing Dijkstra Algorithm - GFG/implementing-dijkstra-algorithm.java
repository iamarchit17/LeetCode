//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// without using Visited Array
// class Solution{
//     //Function to find the shortest distance of all the vertices
//     //from the source vertex S.
//     static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
//         PriorityQueue<int[]> pq = new PriorityQueue<>(V, (l1, l2) -> l1[0] - l2[0]);
//         pq.add(new int[]{0, S});
        
//         int[] dist = new int[V];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[S] = 0;
        
        
//         while(pq.size() != 0){
//             int[] node = pq.poll();
            
//             for(ArrayList<Integer> l : adj.get(node[1])){
//                 if(dist[node[1]] + l.get(1) < dist[l.get(0)]){
//                     dist[l.get(0)] = dist[node[1]] + l.get(1);
//                     pq.add(new int[]{dist[l.get(0)], l.get(0)});
//                 }
//             }
//         }
        
//         return dist;
//     }
// }

class Solution{
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S){
        PriorityQueue<int[]> pq = new PriorityQueue<>(V, (l1, l2) -> l1[0] - l2[0]);
        pq.add(new int[]{0, S});
        
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        
        boolean[] visited = new boolean[V];
        
        while(pq.size() != 0){
            int[] node = pq.poll();
            visited[node[1]] = true;
            
            int d = node[0];
            for(ArrayList<Integer> l : adj.get(node[1])){
                if(!visited[l.get(0)]){
                    if(d + l.get(1) < dist[l.get(0)]){
                        dist[l.get(0)] = dist[node[1]] + l.get(1);
                        pq.add(new int[]{dist[l.get(0)], l.get(0)});
                    }
                }
            }
        }
        
        return dist;
    }
}



