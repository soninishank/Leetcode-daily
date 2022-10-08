class Solution {
    public List<Integer> getRow(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(Arrays.asList(1));
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j = 1 ; j < i; j++)
            {
                list.add(resultList.get(i-1).get(j-1) + resultList.get(i-1).get(j));
            }
            list.add(1);
            resultList.add(list);
        }
        return resultList.get(numRows);
    }
}