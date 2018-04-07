class Solution {
    final int[][] shift = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            dyeT(board, i, 0);
            if (n > 1) {
                dyeT(board, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            dyeT(board, 0, j);
            if (m > 1) {
                dyeT(board, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dyeT(char[][] board, int i, int j) {
        if (board[i][j] == 'X' || board[i][j] == 'T') return;
        board[i][j] = 'T';
        for (int[] dir : shift) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < board.length && y >= 0 && y <= board[0].length) {
                dyeT(board, x, y);
            }
        }
    }
}
