class Solution {
    Stack<String> stack = new Stack<>();

    public String simplifyPath(String path) {
        StringBuilder builder = new StringBuilder();
        // Before : "/home//foo/"
        // After split : "","home","","foo"
        String[] strList = path.split("/");
        for (String str : strList) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (str.equals(".") || str.equals("")) {
                continue;
            } else {
                stack.push(str);
            }
        }
        for (String str : stack) {
            builder.append("/");
            builder.append(str);
        }
        if (builder.length() > 0) {
            return builder.toString();
        } else {
            return "/";
        }
    }
}
