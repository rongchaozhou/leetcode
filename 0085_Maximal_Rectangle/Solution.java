import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] left = new int[n], right = new int[n], height = new int[n];
        Arrays.fill(right, n);
        int maxArea = 0;
        /*for matrix[i][j], if it is '1', we calculate the max area of rectangle containing this '1'
        and all upper conjoint '1's within the rows so far */
        for(int i = 0; i < m; i++) {
            int currL = 0, currR = n;
            for(int j = n-1; j >= 0; j--) {
                if(matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], currR);
                }else {
                    right[j] = n;
                    currR = j;
                }
            }
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], currL);
                    height[j] += 1;
                    maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
                }else {
                    left[j] = 0;
                    currL = j + 1;
                    height[j] = 0;
                }
            }
        }
        return maxArea;
    }
}
