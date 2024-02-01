class Solution {

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            String str = String.valueOf(n);
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                int val = str.charAt(i)-'0';
                sum += val * val;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
        }
        return true;
    }
}
