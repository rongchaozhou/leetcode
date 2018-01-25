import java.util.*;

class Solution {
    public int[][] generateMatrix(int n) {
        int[] shift = {0, 1, 0, -1, 0};
        int[][] res = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int i = 0, j = 0, printer = 1;
        int director = 0;
        while(printer <= n*n){
            res[i][j] = printer++;
            visited[i][j] = true;
            int nextI = i+shift[director];
            int nextJ = j+shift[director+1];
            if(nextI>=0 && nextI<n && nextJ>=0 && nextJ <n && !visited[nextI][nextJ]){
                i = nextI;
                j = nextJ;
            }else{
                director = (director + 1) % 4;
                i += shift[director];
                j += shift[director+1];
            }
        }
        return res;
    }
}