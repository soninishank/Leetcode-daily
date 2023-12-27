class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int end = 0 , start = 0;
        
        int runningSum = 0;
        while(end < arr.length){
            runningSum += arr[end];
            end++;
            if(end - start == k){
                int average = runningSum / k ;
                if(average >= threshold){
                    result++;
                }
                runningSum -= arr[start];
                start++;
            }
        }
        return result;
    }
}