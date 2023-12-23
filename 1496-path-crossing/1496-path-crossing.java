class Solution {
    public boolean isPathCrossing(String path) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        map.put(0, new HashSet<>());
        map.get(0).add(0);
        
        int x = 0, y = 0;
        
        for(int i = 0; i < path.length(); i++){
            if(path.charAt(i) == 'N') y++;
            else if(path.charAt(i) == 'S') y--;
            else if(path.charAt(i) == 'E') x++;
            else x--;
            
            if(map.containsKey(x)){
                if(map.get(x).contains(y)) return true;
            } else {
                map.put(x, new HashSet<>());
            }
            
            map.get(x).add(y);
        }
        
        return false;
    }
}