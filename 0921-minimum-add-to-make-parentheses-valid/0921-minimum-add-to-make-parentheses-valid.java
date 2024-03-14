class Solution {

    public int minAddToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    list.add(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list.size();
    }
}
