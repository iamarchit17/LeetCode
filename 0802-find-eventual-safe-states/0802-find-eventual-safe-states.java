
//BFS Solution - Topological Sort on Reverse Graph
// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         ArrayList<ArrayList<Integer>> revAdjList = new ArrayList<>();
//         for(int i = 0; i < graph.length; i++) revAdjList.add(new ArrayList<>());
        
//         for(int i = 0; i < graph.length; i++){
//             for(int j = 0; j < graph[i].length; j++){
//                 revAdjList.get(graph[i][j]).add(i);
//             }
//         }
        
//         int[] inDegree = new int[graph.length];
//         for(int i = 0; i < revAdjList.size(); i++){
//             for(int x : revAdjList.get(i)) inDegree[x]++;
//         }
        
//         Deque<Integer> dq = new ArrayDeque<>();
//         List<Integer> safe = new ArrayList<>();
        
//         for(int i = 0; i < graph.length; i++){
//             if(inDegree[i] == 0) dq.add(i);
//         }
        
//         while(dq.size() != 0){
//             int node = dq.poll();
//             safe.add(node);
            
//             for(int x : revAdjList.get(node)){
//                 inDegree[x]--;
//                 if(inDegree[x] == 0) dq.add(x);
//             }
//         }
        
//         Collections.sort(safe);
//         return safe;
//     }
// }


//DFS Solution
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] path = new boolean[graph.length];
        
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]) dfs(i, graph, visited, path);
        }
        
        List<Integer> safe = new ArrayList<Integer>();
        for(int i = 0; i < graph.length; i++){
            if(!path[i]) safe.add(i);
        }
        
        return safe;
    }
    
    public boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] path){
        visited[node] = true;
        path[node] = true;
        
        for(int x : graph[node]){
            if(!visited[x]){
                if(dfs(x, graph, visited, path)) return true;
            } else if(path[x]) return true;
        }
        
        path[node] = false;
        return false;
    }
}