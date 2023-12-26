class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Integer> stack =new Stack<>();
        StringBuilder stringBuilder = new StringBuilder(s);
        for(int i = 0 ; i < stringBuilder.length(); i++){
            if(i == 0 || stringBuilder.charAt(i) != stringBuilder.charAt(i-1)){
                stack.push(1);
            }else{
                int total = stack.pop() + 1;
                if(total == k){
                    // public StringBuilder delete(int start, int end) {
                    stringBuilder.delete(i - k + 1, i + 1);
                    i = i - k ; // reduce the pointer
                }else{
                   stack.push(total); 
                }
            }
        }
        return stringBuilder.toString();
    }
}