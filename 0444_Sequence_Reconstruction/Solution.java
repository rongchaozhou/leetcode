class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int[] pos = new int[org.length + 1];
        for (int i = 0; i < org.length; i++) {
            pos[org[i]] = i;
        }
        boolean[] test = new boolean[org.length];
        for (List<Integer> list : seqs) {
            if (list.size() == 0) continue;
            int head = list.get(0);
            if (head > org.length || list.get(0) <= 0) return false;
            if (pos[head] == 0) {
                test[0] = true;
            }
            for (int i = 1; i < list.size(); i++) {
                int pre = list.get(i - 1), curr = list.get(i);
                if (curr > org.length || curr <= 0) return false;
                if (pos[pre] >= pos[curr]) return false;
                if (pos[pre] == pos[curr] - 1) {
                    test[pos[curr]] = true;
                }
            }
        }
        for (boolean b : test) {
            if (!b) return false;
        }
        return true;
    }
}
