class Solution {
    public boolean validTicTacToe(String[] board) {
        int numOfX = 0, numOfO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    numOfX++;
                }
                if (board[i].charAt(j) == 'O') {
                    numOfO++;
                }
            }
        }
        if (numOfX != numOfO && numOfX != numOfO + 1) return false;
        int[] numOfLine = new int[2];
        char[] symbol = new char[]{'X', 'O'};
        for (int k = 0; k < symbol.length; k++) {
            for (int i = 0; i < 3; i++) {
                if (board[i].charAt(0) == symbol[k] && board[i].charAt(1) == symbol[k] && board[i].charAt(2) == symbol[k]) {
                    numOfLine[k]++;
                }
                if (board[0].charAt(i) == symbol[k] && board[1].charAt(i) == symbol[k] && board[2].charAt(i) == symbol[k]) {
                    numOfLine[k]++;
                }
            }
            if (board[0].charAt(0) == symbol[k] && board[1].charAt(1) == symbol[k] && board[2].charAt(2) == symbol[k]) {
                numOfLine[k]++;
            }
            if (board[2].charAt(0) == symbol[k] && board[1].charAt(1) == symbol[k] && board[0].charAt(2) == symbol[k]) {
                numOfLine[k]++;
            }
        }
        if (numOfLine[0] + numOfLine[1] > 1) return false;
        if (numOfLine[0] == 1 && numOfX == numOfO) return false;
        if (numOfLine[1] == 1 && numOfX > numOfO) return false;
        return true;
    }
}
