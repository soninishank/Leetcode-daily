class Solution {
    Stack<Character> stack = new Stack<>();

    public String removeDuplicates(String s) {
        if(s.length() == 0){
            return "";
        }
        for(int i = 0 ; i < s.length() ; i++){
            if(stack.isEmpty()){
               stack.push(s.charAt(i)); 
            }else if(stack.peek() == s.charAt(i)){
                stack.pop();
            }else{
                stack.push(s.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }
}
