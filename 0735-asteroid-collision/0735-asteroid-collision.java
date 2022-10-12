class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int val : asteroids)
        {
            if(val > 0)
            {
                stack.add(val); // ++ , no collission, no need to check prev element
            }else
            {
                while(!stack.isEmpty() && stack.peek() > 0 && Math.abs(val) > stack.peek())
                {
                    stack.pop();// +-, collision occurs, if +ve is smaller remove it
                }
                if(stack.isEmpty() || stack.peek() < 0)
                {
                    stack.push(val); // --, no collission , prev element is also negative
                }
                else if(stack.peek() == Math.abs(val))
                {
                    stack.pop();// +-, val is negative , we need to pop
                }
            }
        }
        return stack.stream().mapToInt(i->i).toArray();
    }
}