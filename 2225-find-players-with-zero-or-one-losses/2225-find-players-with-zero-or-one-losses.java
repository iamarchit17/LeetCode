class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<Integer>());
        list.add(new ArrayList<Integer>());
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < matches.length; i++){
            if(!map.containsKey(matches[i][0])) map.put(matches[i][0], 0);
            if(!map.containsKey(matches[i][1])) map.put(matches[i][1], 0);
        }
        
        for(int i = 0; i < matches.length; i++){
            map.replace(matches[i][1], map.get(matches[i][1]) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 0) list.get(0).add(entry.getKey());
            else if(entry.getValue() == 1) list.get(1).add(entry.getKey());
        }
        
        Collections.sort(list.get(0));
        Collections.sort(list.get(1));
        return list;
    }
}