class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    X.add(i);
                    Y.add(j);
                }
            }
        }
        return getMedium(X) + getMedium(Y);
    }

    private int getMedium(List<Integer> list) {
        Collections.sort(list);
        int i = 0, j = list.size() - 1;
        int res = 0;
        while (i < j) {
            res += list.get(j--) - list.get(i++);
        }
        return res;
    }
}
