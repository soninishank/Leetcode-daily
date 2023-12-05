class Solution {
   public String minRemoveToMakeValid(String s) {
        char[] ch = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ch.length; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && ch[stack.peek()] == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        if (stack.size() == ch.length) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!stack.isEmpty() && i == stack.peek()) {
                stack.pop();
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.reverse().toString();
    }
}