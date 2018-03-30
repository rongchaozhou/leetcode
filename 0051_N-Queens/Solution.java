class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        backtrack(res, new LinkedList<Integer>(), n);
        return res;
    }

    public void backtrack(List<List<String>> res, LinkedList<Integer> curr, int n) {
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
        for (int i = 0; i < n; i++) {
            if (curr.contains(i)) {
                continue;
            }
            boolean diagonal = true;
            for (int j = 0; j < curr.size(); j++) {
                if (i - curr.get(j) == curr.size() - j || i - curr.get(j) == -curr.size() + j) {
                    diagonal = false;
                }
            }
            if (!diagonal) {
                continue;
            }
            curr.add(i);
            backtrack(res, curr, n);
            curr.removeLast();
        }
    }
}
