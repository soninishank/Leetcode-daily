class Solution {
        List<Integer> result = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        int rowMin = 0;
        int rowMax = matrix.length - 1;
        int colMin = 0;
        int colMax = matrix[0].length - 1;

        while (rowMin <= rowMax && colMin <= colMax) {
            // left to right
            for (int i = colMin; i <= colMax; i++) {
                result.add(matrix[rowMin][i]);
            }
            rowMin++;
            for (int i = rowMin; i <= rowMax; i++) {
                result.add(matrix[i][colMax]);
            }
            colMax--;
            if (rowMin <= rowMax) {
                for (int i = colMax; i >= colMin; i--) {
                    result.add(matrix[rowMax][i]);
                }
            }
            rowMax--;
            if (colMin <= colMax) {
                for (int i = rowMax; i >= rowMin; i--) {
                    result.add(matrix[i][colMin]);
                }
            }
            colMin++;
        }
        return result;
    }
}
