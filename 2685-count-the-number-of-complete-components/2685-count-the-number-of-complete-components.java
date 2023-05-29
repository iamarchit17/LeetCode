class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) list.add(new ArrayList<>());
        for(int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        
        //complete connected components -> ccc
        int ccc = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                int[] arr = new int[2];
                dfs(i, list, visited, arr);
                if(arr[0] * (arr[0] - 1) == arr[1]) ccc++;
            }
        }
        
        return ccc;
    }
    
    public void dfs(int node, List<List<Integer>> adjList, boolean[] visited, int[] count){
        visited[node] = true;
        count[0]++;
        count[1] += adjList.get(node).size();
        
        for(int x : adjList.get(node)){
            if(!visited[x]) dfs(x, adjList, visited, count);
        }
    }
}