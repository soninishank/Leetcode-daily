class Solution {

  public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for (List<String> list1 : similarPairs) {
            hashmap.putIfAbsent(list1.get(0), new ArrayList<>());
            hashmap.get(list1.get(0)).add(list1.get(1));

            hashmap.putIfAbsent(list1.get(1), new ArrayList<>());
            hashmap.get(list1.get(1)).add(list1.get(0));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            } else {
                if (!applyDFS(sentence1[i], sentence2[i], hashmap, new HashSet<>())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean applyDFS(String source, String target, HashMap<String, List<String>> hashmap, HashSet<String> visitedSet) {
        visitedSet.add(source);
        if (hashmap.containsKey(source)) {
            for (String str : hashmap.get(source)) {
                if (visitedSet.contains(str)) {
                    continue;
                } else if (str.equals(target)) {
                    return true;
                } else if (applyDFS(str, target, hashmap, visitedSet)) {
                    return true;
                }
            }
        }
        return false;
    }
}