class MinStack {

    Link currentPointer;
    public MinStack() {
        
    }
    
    public void push(int val) {
        if(currentPointer == null){
            currentPointer = new Link(val,val,null);
        }else{
            currentPointer = new Link(Math.min(val,currentPointer.minValue),val,currentPointer);
        }
    }
    
    public void pop() {
         currentPointer = currentPointer.prevPointer;
    }
    
    public int top() {
        return currentPointer.currentValue;
    }
    
    public int getMin() {
        return currentPointer.minValue;
    }
}

class Link {
    int minValue;
    Link prevPointer;
    int currentValue;
    
    Link(int minValue, int currentValue, Link prevPointer){
        this.minValue = minValue;
        this.currentValue = currentValue;
        this.prevPointer = prevPointer;
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