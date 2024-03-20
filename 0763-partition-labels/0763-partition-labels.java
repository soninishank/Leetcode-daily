class Solution {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = i;
        }

        int highIndex = 0;
        int end = 0, start = 0;
        while (end < s.length()) {
            highIndex = Math.max(highIndex, arr[s.charAt(end) - 'a']);
// a and a matched means end is reached to the last position of a character
            if (end == highIndex) {
                result.add(highIndex + 1 - start);
                start = highIndex + 1; // difference
            }
            end++;
        }
        return result;
    }
}
