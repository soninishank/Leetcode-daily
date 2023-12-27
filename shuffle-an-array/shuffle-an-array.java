import java.util.Arrays;

class Solution {
    int[] original;
    Random rand = new Random();

    public Solution(int[] nums) {
        original = nums.clone(); // Create a copy of the input array
    }

    public int[] reset() {
        return original.clone(); // Return a copy of the original array
    }

    public int[] shuffle() {
        int[] temp = original.clone(); // Create a copy of the original array
        for (int i = 0; i < temp.length; i++) {
            int randomIndex = rand.nextInt(temp.length);
            // Swap elements at indices i and randomIndex
            int tmp = temp[i];
            temp[i] = temp[randomIndex];
            temp[randomIndex] = tmp;
        }
        return temp;
    }
}


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */