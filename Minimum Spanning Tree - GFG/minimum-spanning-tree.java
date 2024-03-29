//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
/*
//Prim's Algorithm
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    
	    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
	    for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
	    
	    for(int i = 0; i < edges.length; i++){
	        ArrayList<Integer> l = new ArrayList<>();
	        l.add(edges[i][0]);
	        l.add(edges[i][2]);
	        adj.get(edges[i][1]).add(l);
	        ArrayList<Integer> l1 = new ArrayList<>();
	        l1.add(edges[i][1]);
	        l1.add(edges[i][2]);
	        adj.get(edges[i][0]).add(l1);
	    }
	    
	    boolean[] visited = new boolean[V];
	    
	    PriorityQueue<Pair> pq = new PriorityQueue<>(V, (a, b) -> a.dist - b.dist);
	    pq.add(new Pair(0, 0));
	    
	    int sum = 0;
	    
	    while(pq.size() != 0){
	        Pair p = pq.poll();
	        int d = p.dist;
	        int node = p.node;
	        
	        if(!visited[node]){
	            visited[node] = true;
	            sum += d;
	            
	            for(ArrayList<Integer> nbr : adj.get(node)){
	                if(!visited[nbr.get(0)]) pq.add(new Pair(nbr.get(1), nbr.get(0)));
	            }
	        }
	    }
	    
	    return sum;
	}
}

class Pair{
    int dist, node;
    
    public Pair(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
}
*/

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    Arrays.sort(edges, (l1, l2) -> l1[2] - l2[2]);
	    UnionBySize ubs = new UnionBySize(V);
	    
	    int sum = 0;
	    
	    for(int i = 0; i < E; i++){
	        if(ubs.find(edges[i][0]) != ubs.find(edges[i][1])){
	            sum += edges[i][2];
	            ubs.union(edges[i][0], edges[i][1]);
	        }
	    }
	    
	    return sum;
	}
}

class UnionBySize{
    int[] size, id;
    
    public UnionBySize(int n){
        this.size = new int[n];
        this.id = new int[n];
        
        for(int i = 0; i < n; i++){
            size[i] = 1;
            id[i] = i; 
        }
    }
    
    public int find(int u){
        if(u == id[u]) return u;
        return id[u] = find(id[u]);
    }
    
    public void union(int u, int v){
        int idU = find(u);
        int idV = find(v);
        
        if(idU == idV) return;
        
        if(size[idU] < size[idV]){
            id[idU] = idV;
            size[idV] += size[idU];
        } else {
            id[idV] = idU;
            size[idU] += size[idV];
        }
    }
}





