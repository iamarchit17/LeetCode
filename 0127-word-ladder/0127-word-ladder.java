
//O(N^2 * M) M -> word length, N -> number of words
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         HashSet<String> set = new HashSet<>();
//         set.add(beginWord);
//         Deque<String> dq = new ArrayDeque<>();
//         int dist = 1;
//         dq.add(beginWord);
        
//         //O(N * N * M)
//         while(dq.size() != 0){
//             int size = dq.size();
//             for(int m = 0; m < size; m++){
//                 String s = dq.poll();
//                 //O(N * M)
//                 for(int i = 0; i < wordList.size(); i++){
//                     if(!set.contains(wordList.get(i))){
//                         int x = 0;
//                         //O(M)
//                         for(int j = 0; j < s.length(); j++){
//                             if(s.charAt(j) != wordList.get(i).charAt(j)) x++;
//                         }
                        
//                         if(x == 1){
//                             if(wordList.get(i).equals(endWord)) return dist + 1;
//                             dq.add(wordList.get(i));
//                             set.add(wordList.get(i));
//                         }
//                     }
//                 }
//             }
            
//             dist++;
//         }
        
//         return 0;
//     }
// }

// O(N * M * 26)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList.size());
        for(String s : wordList) set.add(s);
        if(set.contains(beginWord)) set.remove(beginWord);
        
        Deque<String> dq = new ArrayDeque<>();
        int dist = 1;
        dq.add(beginWord);
        
        //O(N * 26 * M)
        while(dq.size() != 0){
            int size = dq.size();
            for(int m = 0; m < size; m++){
                String s = dq.poll();
                //O(N * 26)
                if(s.equals(endWord)) return dist;
                char[] c = s.toCharArray();
                for(int j = 0; j < c.length; j++){
                    for(char k = 'a'; k <= 'z'; k++){
                        c[j] = k;
                        String r = String.valueOf(c);
                        if(set.contains(r)){
                            set.remove(r);
                            dq.add(r);
                        }
                    }
                    
                    c[j] = s.charAt(j);
                }
            }
            dist++;
        }
        
        return 0;
    }
}