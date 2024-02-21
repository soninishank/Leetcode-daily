class WordDictionary {
    TrieNode trieMap;

    public WordDictionary() {
        trieMap = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode start = trieMap;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!start.containsKey(ch)) {
                start.put(ch, new TrieNode());
            }
            start = start.get(ch);
        }
        start.setEnd();
    }

    public boolean search(String word) {
        TrieNode search = trieMap;
        return helper(word, 0, search);
    }

    private boolean helper(String word, int currentIndex, TrieNode root) {
        if (root == null) {
            return false;
        }
        if (currentIndex == word.length()) {
            return root.isEnd();
        }
        if (word.charAt(currentIndex) == '.') {
            for (TrieNode child : root.links) {
                if (child != null && helper(word, currentIndex + 1, child)) {
                    return true;
                }
            }
            return false;
        } // if its not a dot
        else {
            if (!root.containsKey(word.charAt(currentIndex))) {
                return false;
            }
            root = root.get(word.charAt(currentIndex));
            return helper(word, currentIndex + 1, root);
        }
    }
}

class TrieNode {
    public final TrieNode[] links;
    public boolean isEnd;

    public TrieNode() {
        links = new TrieNode[26];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
