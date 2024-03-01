class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                int sum = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                list.add(sum);
            }
            list.add(1);
            result.add(new ArrayList(list));
        }
        return result;
    }
}
