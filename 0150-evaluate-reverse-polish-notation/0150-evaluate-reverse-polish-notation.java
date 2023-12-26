class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int sum = stack.pop() + stack.pop();
                stack.push(sum);
            } else if (tokens[i].equals("/")) {
                int last = stack.pop();
                int first = stack.pop();
                stack.push(first / last);
            } else if (tokens[i].equals("*")) {
                int first = stack.pop();
                int last = stack.pop(); 
                stack.push(first * last);
            } else if (tokens[i].equals("-")) {
               int first = stack.pop();
               int last = stack.pop(); 
                stack.push(last-first);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
