class MinStack {
    Stack<Integer> stack = new Stack<>();
    Node node;

    public MinStack() {}

    public void push(int val) {
        if (node == null) {
            node = new Node(val,null);
        } else {
            node = new Node(val, node);
        }
    }

    public void pop() {
        node = node.next;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.minVal;
    }

    class Node {
        int val;
        Node next;
        int minVal = Integer.MAX_VALUE;

        Node(int data, Node ptr) {
            this.val = data;
            this.next = ptr;
            if(ptr == null)
            {
                this.minVal = data;
            }else
            this.minVal = Math.min(data, ptr.minVal);
        }
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
