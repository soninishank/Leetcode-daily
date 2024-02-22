class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            // existing one
            if(!stack.isEmpty() && stack.peek()[0] == ch){
                stack.peek()[1]++;
            }else{
                stack.push(new int[]{ch,1});
            }
            if(stack.peek()[1] == k){
                stack.pop();
            }
        }
        StringBuilder builder = new StringBuilder();
        while(!stack.isEmpty()){
            int[] topArr = stack.pop();
            while(topArr[1] > 0){
                builder.append((char)topArr[0]);
                topArr[1]--;
            }
        }
        return builder.reverse().toString();
    }
}