class Solution {
    List<String> result = new ArrayList<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> hashSet = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (applyDFS(word, hashSet)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean applyDFS(String word, HashSet<String> hashset) {
        for (int i = 1; i <= word.length(); i++) {
            String substr = word.substring(0, i);
            if (hashset.contains(substr)) {
                String remaining = word.substring(i);
                if (hashset.contains(remaining) || applyDFS(remaining, hashset)) {
                    return true;
                }
            }
        }
        return false;
    }
}
