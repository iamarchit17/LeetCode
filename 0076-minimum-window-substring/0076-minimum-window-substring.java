class Solution {
    public String minWindow(String s, String t) {
        int count = 0;
        int index = -1;
        int minLen = s.length() + 1;

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))) map.replace(t.charAt(i), map.get(t.charAt(i)) + 1);
            else map.put(t.charAt(i), 1);
        }

        int  j = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) == 1) count++;
                map.replace(s.charAt(i), map.get(s.charAt(i)) - 1);
            }

            while(count == map.size()){
                if(map.containsKey(s.charAt(j))){
                    int x = map.get(s.charAt(j));
                    x++;
                    map.replace(s.charAt(j), x);
                    if(x == 1){
                        if(i - j + 1 < minLen){
                            minLen = i - j + 1;
                            index = j;
                        }
                        count--;
                    }
                }
                j++;
            }
            
        }

        return index == -1 ? "" : s.substring(index, index + minLen);
    }
}