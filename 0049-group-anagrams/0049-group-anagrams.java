class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(int i = 0; i < strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            if(!map.containsKey(s)) map.put(s, new ArrayList<>());
            map.get(s).add(strs[i]);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(List<String> l : map.values()) res.add(l);
        
        return res;
    }
}