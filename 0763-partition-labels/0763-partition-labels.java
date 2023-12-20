class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] freq = new int[26];
        
        for(int i = 0; i < s.length(); i++) freq[s.charAt(i) - 97]++;
        
        HashSet<Character> set = new HashSet<>();
        
        List<Integer> res = new ArrayList<>();
        int prevIndex = -1;
        
        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
            freq[s.charAt(i) - 97]--;
            if(freq[s.charAt(i) - 97] == 0){
                set.remove(s.charAt(i));
            }
            
            if(set.size() == 0){
                res.add(i - prevIndex);
                prevIndex = i;
            }
        }
        
        return res;
    }
}