class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 1);
        
        for(int i = 1; i < arr.length; i++){
            if(map.containsKey(arr[i] - difference)){
                map.put(arr[i], map.get(arr[i] - difference) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > max) max = entry.getValue();
        }
        
        return max;
    }
}