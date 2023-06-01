//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++) adj.add(new ArrayList<>());
        for(int i = 0; i < m; i++){
            ArrayList<Integer> l1 = new ArrayList<>();
            l1.add(edges[i][1]);
            l1.add(edges[i][2]);
            adj.get(edges[i][0]).add(l1);
            ArrayList<Integer> l2 = new ArrayList<>();
            l2.add(edges[i][0]);
            l2.add(edges[i][2]);
            adj.get(edges[i][1]).add(l2);
        }
        
        boolean[] visited = new boolean[n+1];
        int[] parent = new int[n+1];
        int[] dist = new int[n+1];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        parent[1] = -1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(n, (l1, l2) -> l1.distance - l2.distance);
        pq.add(new Pair(1, 0));
        
        while(pq.size() != 0){
            Pair p = pq.poll();
            int node = p.node;
            int distance = p.distance;
            visited[node] = true;
            
            if(node == n) break;
            
            for(ArrayList<Integer> l : adj.get(node)){
                if(!visited[l.get(0)]){
                    if(distance + l.get(1) < dist[l.get(0)]){
                        dist[l.get(0)] = distance + l.get(1);
                        pq.add(new Pair(l.get(0), dist[l.get(0)]));
                        parent[l.get(0)] = node;
                    }
                }
            }
            
        }
        
        List<Integer> path = new ArrayList<>();
        if(!visited[n]){
            path.add(-1);
            return path;
        }
        
        int pathNode = n;
        while(parent[pathNode] != -1){
            path.add(pathNode);
            pathNode = parent[pathNode];
        }
        
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}

class Pair{
    int node;
    int distance;
    
    public Pair(int x, int y){
        this.node = x;
        this.distance = y;
    }
}