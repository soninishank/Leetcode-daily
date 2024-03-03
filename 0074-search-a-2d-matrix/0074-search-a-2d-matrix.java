class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;
        while (row <= matrix.length - 1 && col >= 0) {
            int val = matrix[row][col];
            if (val == target) {
                return true;
            } else if (val < target) {
                row++;
            } else if (val > target) {
                col--;
            }
        }
        return false;
    }
}
// [[1,3,5,7],
//  [10,11,16,20],
//  [23,30,34,60]]
