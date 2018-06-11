class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < points.length; j++) {
                if (j == i) continue;
                int dx = points[j][0] - x1, dy = points[j][1] - y1;
                int distance = dx * dx + dy * dy;
                map.put(distance, 1 + map.getOrDefault(distance, 0));
            }
            for (int v : map.values()) {
                res += v * (v - 1);
            }
            map.clear();
        }
        return res;
    }
}
