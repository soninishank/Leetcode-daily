class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popPtr = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[popPtr]) {
                stack.pop();
                popPtr++;
            }
        }
        return stack.isEmpty();
    }
}
