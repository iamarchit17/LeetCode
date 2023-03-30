class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 97]++;
        }
            
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        int i = 0;
        while(i < s.length() && freq[s.charAt(i) - 97] == 1){
            list.add(1);
            i++;
        }
        
        if(i < s.length()) map.put(s.charAt(i), freq[s.charAt(i) - 97] - 1);
        int j = i;
        i++;
        
        for(; i < s.length(); i++){
            
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) == 1) map.remove(s.charAt(i));
                else map.replace(s.charAt(i), map.get(s.charAt(i)) - 1);
            } else {
                if(freq[s.charAt(i) - 97] > 1) map.put(s.charAt(i), freq[s.charAt(i) - 97] - 1);
            }
            
            if(map.size() == 0){
                list.add(i - j + 1);
                j = i + 1;
            }
        }
        
        return list;
    }
}