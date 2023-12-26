class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n == 0){
            return result;
        }
        doBacktrack(0,0,n,"");
        return result;
    }
    
    void doBacktrack(int open, int close,int n , String str){
        if(n * 2 == str.length()){
            result.add(str);
            return;
        }
        if(open < n){
            doBacktrack(open+1,close,n,str+"(");
        }
        if(close < open){
            doBacktrack(open,close+1,n,str+")");
        }
    }
}