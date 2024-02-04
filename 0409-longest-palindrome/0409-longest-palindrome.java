class Solution {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        int odd = 0;
        for (Character c : hashmap.keySet()) {
            int value = hashmap.get(c);
            if (value % 2 == 0) {
                count += value;
            }
            else { // It was an odd number
                count += value - 1; // even 
                odd++;
            }
        } 
        if(odd > 0){
            return count + 1;
        }
        return count ;
    }
}
