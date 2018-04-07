class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int[] costSoFar = new int[A.length];
        int[] lastIndex = new int[A.length];
        int[] pathLength = new int[A.length];
        Arrays.fill(costSoFar, Integer.MAX_VALUE);
        Arrays.fill(lastIndex, -1);
        costSoFar[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] == -1) {
                continue;
            }
            for (int j = Math.max(0, i - B); j < i; j++) {
                if (costSoFar[j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (costSoFar[j] + A[i] < costSoFar[i] || costSoFar[j] + A[i] == costSoFar[i] && pathLength[j] + 1 > pathLength[i]) {
                    costSoFar[i] = costSoFar[j] + A[i];
                    lastIndex[i] = j;
                    pathLength[i] = pathLength[j] + 1;
                }
            }
        }

        List<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; costSoFar[i] != Integer.MAX_VALUE && i >= 0; i = lastIndex[i]) {
            res.add(0, i + 1);
        }
        return res;
    }
}
