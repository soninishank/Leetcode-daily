class FreqStack {
    HashMap<Integer, Integer> freqMap = new HashMap<>();
    HashMap<Integer, Stack<Integer>> freqStack = new HashMap<>();
    int maxFreq = 0;

    public FreqStack() {}

    public void push(int val) {
        int totalFreq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val,totalFreq);
        maxFreq = Math.max(maxFreq,totalFreq);
        freqStack.computeIfAbsent(totalFreq, c -> new Stack()).push(val);
    }

    public int pop() {
        int x = freqStack.get(maxFreq).pop();
        freqMap.put(x,freqMap.getOrDefault(x, 0) - 1);
        if(freqStack.get(maxFreq).size() == 0){
            maxFreq--;
        }
        return x;
    }
}
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
