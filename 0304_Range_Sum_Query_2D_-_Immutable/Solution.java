class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        sum = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            if (col1 == 0) {
                res += sum[i][col2];
            } else {
                res += sum[i][col2] - sum[i][col1 - 1];
            }
        }
        return res;
    }
}
