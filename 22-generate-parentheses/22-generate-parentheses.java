class Solution {
    private List<String> resultString = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        backtrackString(n, "", 0, 0);
        return resultString;
    }

    private void backtrackString(int n, String str, int open, int close) {
        if (str.length() == n * 2) {
            resultString.add(str);
        }
        if (open < n) {
            backtrackString(n, str + "(", open + 1, close);
        }
        if (close < open) {
            backtrackString(n, str + ")", open, close + 1);
        }
    }
}
