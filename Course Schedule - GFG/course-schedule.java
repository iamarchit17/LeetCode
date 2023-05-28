//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        ArrayList<ArrayList<Integer>> adj = makeGraph(n, prerequisites);
        
        boolean[] visited = new boolean[n];
        boolean[] path = new boolean[n];
        
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(!visited[i]) dfs(i, path, visited, dq, adj);
        }
        
        if(dq.size() < n) return new int[0];
        
        int[] order = new int[n];
        for(int i = 0; i < n; i++){
            order[i] = dq.pop();
        }
        
        return order;
    }
    
    static ArrayList<ArrayList<Integer>> makeGraph(int n, ArrayList<ArrayList<Integer>> preqs){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());
        
        for(int i = 0; i < preqs.size(); i++) list.get(preqs.get(i).get(1)).add(preqs.get(i).get(0));
        
        return list;
    }
    
    static boolean dfs(int node, boolean[] path, boolean[] visited, Deque<Integer> dq, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        path[node] = true;
        
        for(int x : adj.get(node)){
            if(!visited[x]){
                if(dfs(x, path, visited, dq, adj)) return true;
            } else if(path[x]) return true;
        }
        
        dq.push(node);
        path[node] = false;
        return false;
    }
}