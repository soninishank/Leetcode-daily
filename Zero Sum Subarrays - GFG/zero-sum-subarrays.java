//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    int n;
		    n=sc.nextInt();
		    
		    long arr[]=new long[n];
	
		    
		    for(int i=0;i<n;i++)
		    {
		        arr[i]=sc.nextLong();
		    }
            Solution ob = new Solution();
		    System.out.println(ob.findSubarray(arr,n));
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        //Your code here
         HashMap<Integer, Integer> hashMap = new HashMap<>();
        int runningSum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            runningSum += arr[i];
            if (runningSum == 0) {
                count++;
            }
            if (hashMap.containsKey(runningSum - 0)) {
                count += hashMap.get(runningSum - 0);
            }
            hashMap.put(runningSum, hashMap.getOrDefault(runningSum, 0) + 1);
        }
        return count;
    }
}