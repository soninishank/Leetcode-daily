class Solution {

    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> hashset = new HashSet<Integer>();
        for (int val : nums) {
            hashset.add(val);
             hashset.add(getReverse(val));
        }
        return hashset.size();
    }
    
    
    private int getReverse(int num)
    {
        int result = 0;
        while(num > 0)
        {
            int remainder = num % 10;
            result = result * 10 + remainder;
            num = num /10;
        }
        return result;
    }
}
