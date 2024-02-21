class Trie {
    
    private final TrieNode buildingTrie;

    public Trie() {
        buildingTrie = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode start = buildingTrie;
        for(int i = 0 ; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if(!start.containsKey(currentChar)){
                start.put(currentChar,new TrieNode());
            }
            start = start.get(currentChar); // its a new object
        }
        start.setEnd();
    }
    
    public boolean search(String word) {
        TrieNode search = buildingTrie;
        for(int i = 0 ; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if(!search.containsKey(currentChar)){
                return false;
            }
            search = search.get(currentChar);
        }
        return search != null && search.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode startsWith = buildingTrie;
        for(int i = 0 ; i < prefix.length(); i++){
            char currentChar = prefix.charAt(i);
            if(!startsWith.containsKey(currentChar)){
                return false;
            }
            startsWith = startsWith.get(currentChar);
        }
         return startsWith != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */


class TrieNode {
    private final TrieNode[] links;
    private boolean isEnd;
    
    public TrieNode(){
        this.links = new TrieNode[26];
    }
    
    public void put(char ch, TrieNode trieNode){
        links[ch-'a'] = trieNode;
    }
    
    public boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }
    public TrieNode get(char ch){
        return links[ch-'a'];
    }
    
    public void setEnd(){
        isEnd = true;
    }
    
    public boolean isEnd(){
        return isEnd;
    }
}
