class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){
            if(map.containsKey(tasks[i])) map.replace(tasks[i], map.get(tasks[i]) + 1);
            else map.put(tasks[i], 1);
        }
        
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) return -1;
            else ans += ((entry.getValue() + 2)/3);
        }
        
        return ans;
    }
}