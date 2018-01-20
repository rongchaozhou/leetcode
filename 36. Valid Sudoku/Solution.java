import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> row = new LinkedList<>();
        List<HashSet<Character>> column = new LinkedList<>();
        List<HashSet<Character>> cube = new LinkedList<>();
        for(int i = 0; i< 9; i++){
            row.add(new HashSet<Character>());
            column.add(new HashSet<Character>());
            cube.add(new HashSet<Character>());
        }
        for(int i = 0; i< 9; i++){
            for(int j = 0; j< 9; j++){
                if(board[i][j] != '.' && (!row.get(i).add(board[i][j]) || !column.get(j).add(board[i][j]) || !cube.get(3*(i/3)+j/3).add(board[i][j]))){
                    return false;
                }
            }
        }
        return true;
    }
}