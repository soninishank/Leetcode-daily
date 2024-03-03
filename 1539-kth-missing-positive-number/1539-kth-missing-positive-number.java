class Solution {

    public int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= arr.length + k; i++) {
            if (list.contains(i)) {
                continue;
            } else if (list1.size() <= k) {
                list1.add(i);
            }
        }
        System.out.println(list1);
        return list1.get(k-1);
    }
}
