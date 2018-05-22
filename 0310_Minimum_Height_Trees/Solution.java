class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> neighbor = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            neighbor.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            neighbor.get(edge[0]).add(edge[1]);
            neighbor.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (neighbor.get(i).size() == 1) {
                leaves.add(i);
            }
        }

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                for (int adj : neighbor.get(leaf)) {
                    neighbor.get(adj).remove(leaf);
                    if (neighbor.get(adj).size() == 1) {
                        newLeaves.add(adj);
                    }
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
