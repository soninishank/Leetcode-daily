class Solution {

    public void rotate(int[][] matrix) {
        int low = 0;
        int high = matrix.length - 1;

        while (low <= high) {
            int[] temp = matrix[low];
            matrix[low] = matrix[high];
            matrix[high] = temp;
            low++;
            high--;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
// 7 8 9
// 4 5 6
// 1 2 3

// 8 -> row 0 col 1 
// 4 
