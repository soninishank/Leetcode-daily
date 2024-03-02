// https://leetcode.com/problems/next-permutation/discuss/13994/Readable-code-without-confusing-ij-and-with-explanation
class Solution {

    public void nextPermutation(int[] nums) {
        int pivot = findPivot(nums); 
        System.out.println(pivot);
        if (pivot != -1) {
            int nextSuccessor = findNextSuccessor(nums, pivot);
            swap(nums, pivot, nextSuccessor);
        }
        reverseAfterPivot(nums, pivot + 1); // 3,2,1
    }

    // R.H.S
    private int findPivot(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    // R.H.S
    private int findNextSuccessor(int[] nums, int pivot) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[pivot]) {
                return i;
            }
        }
        return 0;
    }

    private void swap(int[] arr, int pivot, int successor) {
        int temp = arr[pivot];
        arr[pivot] = arr[successor];
        arr[successor] = temp;
    }

    private void reverseAfterPivot(int[] arr, int pivotNext) {
        int high = arr.length - 1;
        while (pivotNext <= high) {
            int temp = arr[pivotNext];
            arr[pivotNext] = arr[high];
            arr[high] = temp;
            high--;
            pivotNext++;
        }
    }
}
