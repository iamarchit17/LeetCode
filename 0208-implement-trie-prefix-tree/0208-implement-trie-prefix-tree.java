class Trie {
    TrieNode root;
    
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode(){
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++){
            if(temp.children[word.charAt(i) - 97] == null) temp.children[word.charAt(i) - 97] = new TrieNode();
            temp = temp.children[word.charAt(i) - 97];
        }
        
        temp.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++){
            if(temp.children[word.charAt(i) - 97] == null) return false;
            temp = temp.children[word.charAt(i) - 97];
        }
        
        return temp.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for(int i = 0; i < prefix.length(); i++){
            if(temp.children[prefix.charAt(i) - 97] == null) return false;
            temp = temp.children[prefix.charAt(i) - 97];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */