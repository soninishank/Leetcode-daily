class CustomStack {
    int size = 0;
    List<Integer> linkedList = new LinkedList<>();

    public CustomStack(int maxSize) {
        this.size = maxSize;
    }

    public void push(int x) {
        if (linkedList.size() < size) {
            linkedList.add(x);
        }
    }

    public int pop() {
        if (linkedList.size() > 0) {
            return linkedList.remove(linkedList.size() - 1);
        }
        return -1;
    }

    public void increment(int k, int val) {
        int diff = Math.min(k, linkedList.size());
        ListIterator<Integer> listIterator = linkedList.listIterator();
        while (listIterator.hasNext() && diff != 0) {
            Integer next = listIterator.next();
            int values = next + val;
            listIterator.set(values);
            diff--;
        }
    }
}
/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
