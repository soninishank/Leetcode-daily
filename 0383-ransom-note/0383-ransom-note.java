class Solution {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int val = magazine.charAt(i) - 'a';
            arr[val]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int val = ransomNote.charAt(i) - 'a';
            arr[val]--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
