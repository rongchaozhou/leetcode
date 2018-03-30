class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        backtrack(res, new LinkedList<>(), n, new boolean[n], new boolean[n * 2 - 1], new boolean[n * 2 - 1]);
        return res;
    }

    public void backtrack(List<List<String>> res, LinkedList<Integer> curr, int n, boolean[] colTest, boolean[] diagTest1, boolean[] diagTest2) {
        if (curr.size() == n) {
            List<String> temp = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                char[] array = new char[n];
                Arrays.fill(array, '.');
                array[curr.get(i)] = 'Q';
                temp.add(new String(array));
            }
            res.add(temp);
            return;
        }
        int row = curr.size();
        for (int col = 0; col < n; col++) {
            int id1 = row - col + n - 1, id2 = 2 * n - row - col - 2;
            if (!colTest[col] && !diagTest1[id1] && !diagTest2[id2]) {
                curr.add(col);
                colTest[col] = true;
                diagTest1[id1] = true;
                diagTest2[id2] = true;
                backtrack(res, curr, n, colTest, diagTest1, diagTest2);
                curr.removeLast();
                colTest[col] = false;
                diagTest1[id1] = false;
                diagTest2[id2] = false;
            }
        }
    }
}
