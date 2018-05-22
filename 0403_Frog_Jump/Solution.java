class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>(); //map: stone -> optional jump range
        int end = stones[stones.length - 1];
        for (int i = 0; i < stones.length - 1; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(stones[0]).add(1);
        for (int i = 0; i < stones.length - 1; i++) {
            for (int foot : map.get(stones[i])) {
                int next = stones[i] + foot;
                if (next == end) {
                    return true;
                } else if (map.containsKey(next)) {
                    map.get(next).add(foot + 1);
                    map.get(next).add(foot);
                    if (foot > 1) {
                        map.get(next).add(foot - 1);
                    }
                }
            }
        }
        return false;
    }
}
