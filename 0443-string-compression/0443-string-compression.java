class Solution {

    // Add integer only if the count is greater than 1
    public int compress(char[] chars) {
        if (chars.length == 0) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int end = 0;
        int index = 0;
        while (end < chars.length) {
            char c1 = chars[end];
            end++;
            chars[index] = c1;
            index++;
            stringBuilder.append(c1);
            int count = 1;
            while (end < chars.length && chars[end] == c1) {
                count++;
                end++;
            }
            if (count > 1) {
                for(char c : String.valueOf(count).toCharArray()){
                    chars[index] = c;
                    index++;
                }
            }
        }
        return index;
    }
}
