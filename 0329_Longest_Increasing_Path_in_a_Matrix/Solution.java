class Solution {
    final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[][] visited = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j, visited));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] visited) {
        if (visited[i][j] != 0) {
            return visited[i][j];
        }
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (!(x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j])) {
                max = Math.max(max, dfs(matrix, x, y, visited) + 1);
            }
        }
        visited[i][j] = max;
        return max;
    }
}
