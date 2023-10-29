class Solution {
    public int[] numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        
        int[] res = new int[2];
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            res[0] += (entry.getValue() / 2);
            res[1] += (entry.getValue() % 2);
        }
        
        return res;
    }
}