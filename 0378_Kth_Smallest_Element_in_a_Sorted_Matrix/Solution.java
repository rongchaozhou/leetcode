class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j < n; j++) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (; k > 1; k--) {
            Tuple t = pq.poll();
            if (t.row == n - 1) continue;
            pq.offer(new Tuple(t.row + 1, t.col, matrix[t.row + 1][t.col]));
        }
        return pq.poll().val;
    }

    class Tuple implements Comparable<Tuple> {
        int row, col;
        int val;

        Tuple(int r, int c, int v) {
            row = r;
            col = c;
            val = v;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }
}
