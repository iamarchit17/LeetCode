//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
		for(int i = 0; i < N; i++) adj.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++){
		    ArrayList<Integer> l = new ArrayList<>();
		    l.add(edges[i][1]);
		    l.add(edges[i][2]);
		    adj.get(edges[i][0]).add(l);
		}
		
		Deque<Integer> dq = new ArrayDeque<>();
		boolean[] visited = new boolean[N];
		topoSort(0, adj, visited, dq);
		
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		
		while(dq.size() != 0){
		    int node = dq.pop();
		    
		    for(ArrayList<Integer> l : adj.get(node)){
		        if(dist[node] + l.get(1) < dist[l.get(0)]){
		            dist[l.get(0)] = dist[node] + l.get(1);
		        }
		    }
		}
		
		for(int i = 0; i < N; i++){
		    if(dist[i] == Integer.MAX_VALUE) dist[i] = -1;
		}
		
		return dist;
	}
	
	public void topoSort(int node, ArrayList<ArrayList<ArrayList<Integer>>> adj, boolean[] visited, Deque<Integer> dq){
	    visited[node] = true;
	    
	    for(ArrayList<Integer> l : adj.get(node)){
	        if(!visited[l.get(0)]) topoSort(l.get(0), adj, visited, dq);
	    }
	    
	    dq.push(node);
	}
}