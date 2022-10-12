class Solution {

    public int minDeletions(String s) {
        int[] freqMap = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqMap[s.charAt(i) - 'a']++;
        }
        HashSet<Integer> hashset = new HashSet<>();
        int deletion = 0;
        for(int val : freqMap)
        {
            while(val != 0 && hashset.contains(val))
            {
                val--;
                deletion++;
            }
            hashset.add(val);
        }
        return deletion;
    }
}
