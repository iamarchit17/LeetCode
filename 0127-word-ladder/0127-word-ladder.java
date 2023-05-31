class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        set.add(beginWord);
        Deque<String> dq = new ArrayDeque<>();
        int dist = 1;
        dq.add(beginWord);

        while(dq.size() != 0){
            int size = dq.size();
            for(int m = 0; m < size; m++){
                String s = dq.poll();

                for(int i = 0; i < wordList.size(); i++){
                    if(!set.contains(wordList.get(i))){
                        int x = 0;
                        for(int j = 0; j < s.length(); j++){
                            if(s.charAt(j) != wordList.get(i).charAt(j)) x++;
                        }
                        
                        if(x == 1){
                            if(wordList.get(i).equals(endWord)) return dist + 1;
                            dq.add(wordList.get(i));
                            set.add(wordList.get(i));
                        }
                    }
                }
            }
            
            dist++;
        }
        
        return 0;
    }
}