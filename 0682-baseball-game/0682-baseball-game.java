class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int totalSum = 0;
        for(int i = 0 ; i < operations.length ; i++){
            String str = operations[i];
            if(str.equals("C") ){
                stack.pop();
            }else if(str.equals("D")){
                int val = stack.peek();
                stack.push(val * 2);
            }else if(str.equals("+")){
                int first = stack.pop();
                int last = stack.pop();
                int sum = first+last;
                stack.push(last);
                stack.push(first);
                stack.push(sum);
            }else{
                 int val = Integer.valueOf(str);
                  stack.push(val);
            }
        }
        while(!stack.isEmpty()){
            totalSum += stack.pop();
        }
        return totalSum;
    }
}