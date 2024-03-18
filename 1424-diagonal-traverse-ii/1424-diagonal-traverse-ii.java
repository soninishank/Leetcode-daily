class Solution {
    HashMap<Integer, List<Integer>> hashmap = new HashMap<>();

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        if (nums.size() == 0) {
            return new int[0];
        }
        int maxSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int keyNum = i + j;
                maxSum = Math.max(maxSum,keyNum);
                if (!hashmap.containsKey(keyNum)) {
                    hashmap.put(keyNum, new ArrayList<>());
                }
                hashmap.get(keyNum).add(nums.get(i).get(j));
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0 ; i <= maxSum; i++) {
            List<Integer> res = hashmap.get(i);
            for (int j = res.size() - 1; j >= 0; j--) {
                list.add(res.get(j));
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
