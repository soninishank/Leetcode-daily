class Solution {
    int[] arr = new int[26];
    public int firstUniqChar(String s) {
        for(int i = 0 ; i < s.length(); i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i = 0 ; i < s.length(); i++)
        {
            if(arr[s.charAt(i)-'a'] == 1)
            {
                return i;
            }
        }
        return -1;
    }
}

// leetcode
// l - 0
// e - 1
