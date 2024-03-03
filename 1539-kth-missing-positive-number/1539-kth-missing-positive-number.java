class Solution {
    public int findKthPositive(int[] arr, int k) {
        int num = 1;
        for(int i = 0 ; i < arr.length && k >0;){
            if(arr[i] == num){
                 i++;
            }else{
                k--;
            }
            num++;
        }
        while(k > 0){
            k--;
            num++;
        }
        return num - 1;
    }
}