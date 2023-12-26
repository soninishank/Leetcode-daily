class MyStack {
    Queue<Integer> queue = new LinkedList<>();
    Queue<Integer> extraQueue = new LinkedList<>();
    int top;

    public MyStack() {}

    public void push(int x) {
        top = x;
        queue.add(x);
    }

    public int pop() {
        while (queue.size() > 1) {
            top = queue.poll();
            extraQueue.add(top);
        }
        int val = queue.poll();
        while(!extraQueue.isEmpty()){
            queue.add(extraQueue.poll());
        }
        return val;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue.isEmpty() && extraQueue.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
