class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> invalidChars = new ArrayList<>();
        char[] ch = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(ch[i] == '('){
                stack.push(i);
            }else if(ch[i]==')'){
                if(stack.isEmpty()){
                    invalidChars.add(i);
                }else if(ch[stack.peek()] == '('){
                    stack.pop();
                }
            }
        }
        // "))(("
        while(!stack.isEmpty()){
            invalidChars.add(stack.pop());
        }
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < ch.length; i++){
            if(!invalidChars.contains(i)){
             builder.append(ch[i]);   
            }
        }
        return builder.toString();
    }
}