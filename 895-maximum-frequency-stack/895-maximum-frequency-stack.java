class FreqStack {
    int maxFreq;
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;

    public FreqStack() {
        freq = new HashMap<Integer, Integer>();
        group = new HashMap<>();
    }

    public void push(int val) {
        int totalCount = freq.getOrDefault(val, 0) + 1;
        freq.put(val, totalCount);
        if (totalCount > maxFreq) {
            maxFreq = totalCount;
        }
        group.putIfAbsent(totalCount, new Stack<>());
        group.get(totalCount).add(val);
    }

    public int pop() {
        int key = group.get(maxFreq).pop();
        freq.put(key, freq.getOrDefault(key, 0) - 1);
        if (group.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return key;
    }
}
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
// FrequencyStack
// Frequency -> element
// Frequncy Map
// Key -> Frequency
