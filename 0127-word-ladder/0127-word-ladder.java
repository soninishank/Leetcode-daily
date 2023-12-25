class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> uniqueWords = new HashSet<>(wordList);
        HashSet<String> visitedWords = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visitedWords.add(beginWord);

        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return count;
                }
                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k <= 'z'; k++) {
                        char[] arr = word.toCharArray();
                        arr[j] = (char) k;

                        String newStr = String.valueOf(arr);
                        if (uniqueWords.contains(newStr) && !visitedWords.contains(newStr)) {
                            queue.add(newStr);
                            visitedWords.add(newStr);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
