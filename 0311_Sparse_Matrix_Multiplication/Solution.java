class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rA = A.length, cA = A[0].length, cB = B[0].length;
        int[][] res = new int[rA][cB];
        for (int i = 0; i < rA; i++) {
            for (int j = 0; j < cA; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < cB; k++) {
                        res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return res;
    }
}
