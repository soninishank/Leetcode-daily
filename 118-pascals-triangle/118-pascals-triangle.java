class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < result.get(i - 1).size(); j++) {
                list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            list.add(1);
            result.add(new ArrayList<>(list));
        }
        return result;
    }
    
}

// 1
// 1, 1
// 1,2,1
// 1  3  3  1
// 1  4   6  4    1