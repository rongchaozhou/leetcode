import java.util.*;

class Solution {
    int[] shift = {0, 1, 0, -1, 0};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new LinkedList<>();
        if(m <= 0 || n <= 0) return ans;
        int count = 0;
        int[] roots = new int[m * n];
        Arrays.fill(roots,  -1);
        for(int[] pos : positions) {
            int id = pos[0] * n + pos[1];
            roots[id] = id;
            count++;
            for(int i = 0; i < 4; i++) {
                int row = pos[0] + shift[i];
                int col = pos[1] + shift[i + 1];
                int neighbour = row * n + col;
                if(row < 0 || row >= m || col < 0 || col >= n || roots[neighbour] == -1) continue;
                int root = findRoot(roots, neighbour);
                if(root != id) {
                    roots[id] = root;
                    id = root;
                    count--;
                }
            }
            ans.add(count);
        }
        return ans;
    }
    public int findRoot(int[] roots, int id) {
        while(id != roots[id]) {
            id = roots[id];
        }
        return id;
    }
}
