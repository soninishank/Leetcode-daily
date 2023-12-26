class Solution {

    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();

        // Popping part from stack - main logic
        for (int i = 0; i < num.length(); i++) {
            int val = num.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() > val && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(val);
        }

        // It might be possible that some string are string left
        while (k > 0) {
            k--;
            stack.pop();
        }

        // build StringBuilder
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();

        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}
