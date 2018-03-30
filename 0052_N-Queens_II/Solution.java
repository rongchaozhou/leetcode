class Solution {
    int cnt = 0;

    public int totalNQueens(int n) {
        backtrack(0, n, new boolean[n], new boolean[n * 2 - 1], new boolean[n * 2 - 1]);
        return cnt;
    }

    private void backtrack(int row, int n, boolean[] colTest, boolean[] diagTest1, boolean[] diagTest2) {
        if (row == n) {
            cnt++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int id1 = row - col + n - 1, id2 = row + col;
            if (!colTest[col] && !diagTest1[id1] && !diagTest2[id2]) {
                colTest[col] = true;
                diagTest1[id1] = true;
                diagTest2[id2] = true;
                backtrack(row + 1, n, colTest, diagTest1, diagTest2);
                colTest[col] = false;
                diagTest1[id1] = false;
                diagTest2[id2] = false;
            }
        }
    }
}
