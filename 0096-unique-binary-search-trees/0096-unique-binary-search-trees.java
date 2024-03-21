class Solution {

    // memoMap is the dp memoization , it will reduce the runtime 
    HashMap<Pair<Integer,Integer>,Integer> memoMap = new HashMap<>();
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        return solve(1, n);
    }

    private int solve(int start, int end) {
        int count = 0;
        if (start > end) {
            return 1;
        }
        if(memoMap.containsKey(new Pair<>(start,end))){
            return memoMap.get(new Pair<>(start,end));
        }
        if (start == end) {
            return 1;
        }
        for (int i = start; i <= end; i++) {
            int leftCount = solve(start, i - 1);
            int rightCount = solve(i + 1, end);

            count += leftCount * rightCount; // for loop is same as multiplication
        }
        memoMap.put(new Pair(start,end),count);
        return count;
    }
}
