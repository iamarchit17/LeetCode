//Time Limit Exceeded
//not a wrong solution (accepted on gfg)
//predicting time complexity is difficult

// class Solution {
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         HashSet<String> set = new HashSet<>(wordList.size());
//         for(String s : wordList) set.add(s);
        
//         if(set.contains(beginWord)) set.remove(beginWord);
//         List<String> temp = new ArrayList<>();
//         temp.add(beginWord);
        
//         Deque<List<String>> dq = new ArrayDeque<>();
//         dq.add(temp);
//         boolean flag = false;
        
//         while(dq.size() != 0){
//             if(!flag){
//                 int size = dq.size();
//                 HashSet<String> rem = new HashSet<>();

//                 for(int i = 0; i < size; i++){
//                     List<String> l = dq.poll();
//                     String s = l.get(l.size() - 1);
//                     char[] c = s.toCharArray();

//                     for(int j = 0; j < c.length; j++){
//                         for(char k = 'a'; k <= 'z'; k++){
//                             c[j] = k;
//                             String r = String.valueOf(c);
//                             if(set.contains(r)){
//                                 if(r.equals(endWord)) flag = true;
//                                 List<String> newList = new ArrayList<>(l);
//                                 newList.add(r);
//                                 dq.add(newList);
//                                 rem.add(r);
//                             }
                            
//                             c[j] = s.charAt(j);
//                         }
//                     }
//                 }
                
//                 for(String s : rem) set.remove(s);
//             } else break;
//         }
        
//         List<List<String>> res = new ArrayList<>();
//         while(dq.size() != 0){
//             List<String> l = dq.poll();
//             if(l.get(l.size() - 1).equals(endWord)) res.add(l);
//         }
        
//         return res;
//     }
// }


class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>(wordList.size());
        for(String s : wordList) set.add(s);
        
        if(set.contains(beginWord)) set.remove(beginWord);
        
        map.put(beginWord, 0);
        Deque<String> dq = new ArrayDeque<>();
        int dist = 0;
        dq.add(beginWord);
        boolean flag = false;
        while(dq.size() != 0){
            dist++;
            int size = dq.size();
            
            for(int i = 0; i < size; i++){
                String s = dq.poll();
                char[] c = s.toCharArray();
                
                for(int j = 0; j < c.length; j++){
                    for(char k = 'a'; k <= 'z'; k++){
                        c[j] = k;
                        String r = String.valueOf(c);
                        if(set.contains(r)){
                            set.remove(r);
                            map.put(r, dist);
                            dq.add(r);
                            if(r.equals(endWord)){
                                flag = true;
                                break;
                            }
                        }
                    }
                    
                    c[j] = s.charAt(j);
                    
                    if(flag) break;
                }
            }
            
            if(flag) break;
        }
        
        List<List<String>> res = new ArrayList<>();
        if(!map.containsKey(endWord)) return res;
        List<String> l = new ArrayList<>();
        l.add(endWord);
        dfs(endWord, l, map, res);
        return res;
        
    }
    
    public void dfs(String end, List<String> list, HashMap<String, Integer> map, List<List<String>> res){
        if(map.get(end) == 0){
            List<String> p = new ArrayList<>(list);
            Collections.reverse(p);
            res.add(p);
            return;
        }
        
        char[] c = end.toCharArray();
        for(int i = 0; i < c.length; i++){
            for(char j = 'a'; j <= 'z'; j++){
                c[i] = j;
                String r = String.valueOf(c);
                if(map.containsKey(r) && map.get(r) == map.get(end) - 1){
                    list.add(r);
                    dfs(r, list, map, res);
                    list.remove(list.size() - 1);
                }
            }
            c[i] = end.charAt(i);
        }
        
        
    }
}




























