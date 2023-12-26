public class StockSpanner {
    Stack<StackPair> stack = new Stack<>();
    int index = 0;

    public StockSpanner() {}

    public int next(int price) {
        while (!stack.isEmpty() && stack.peek().currentValue <= price) {
            stack.pop();
        }
        int result = 0;
        if (stack.isEmpty()) {
            result = index + 1;
        } else {
            result = index - stack.peek().index;
        }
        stack.push(new StackPair(price, index));
        index++;
        return result;
    }
}

class StackPair {
    int currentValue;
    int index;

    StackPair(int currentValue, int index) {
        this.currentValue = currentValue;
        this.index = index;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
