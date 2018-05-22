class Solution {
    int[][] neighbors = new int[][]{{-1, -1}, {0, -1}, {1, -1}, {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighborAlive = 0;
                for (int[] dir : neighbors) {
                    int x = i + dir[0], y = j + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] & 1) == 1) {
                        neighborAlive++;
                    }
                }
                if (board[i][j] == 1 && (neighborAlive == 2 || neighborAlive == 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && neighborAlive == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
        return;
    }
}
