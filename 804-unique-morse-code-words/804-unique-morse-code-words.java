class Solution {
    public int uniqueMorseRepresentations(String[] words) {
       String[] MORSE = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                         "....","..",".---","-.-",".-..","--","-.",
                         "---",".--.","--.-",".-.","...","-","..-",
                         "...-",".--","-..-","-.--","--.."};
        HashSet<String> hashset = new HashSet<>();
        for(String str : words)
        {
            char[] ch = str.toCharArray();
            String result = "";
            for(int i = 0 ; i < ch.length; i++)
            {
                int index = ch[i]-'a';
                String str1 = MORSE[index];
                result += str1;
            }
             hashset.add(result);
        }
        return hashset.size();
    }
}

