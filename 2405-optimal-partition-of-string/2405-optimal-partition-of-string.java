class Solution {

    public int partitionString(String s) {
        int count = 0;
        Set<Character> list = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (list.isEmpty()) {
                list.add(c1);
            } else if (list.contains(c1)) {
                count++;
                list = new HashSet<>();
                list.add(c1);
            } else {
                list.add(c1);
            }
        }
        if (!list.isEmpty()) {
            count++;
        }
        return count;
    }
}
