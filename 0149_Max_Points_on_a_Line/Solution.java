class Solution {
    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int result = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j].x - points[i].x;
                int dy = points[j].y - points[i].y;
                if (dx == 0 && dy == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGCD(dx, dy);
                dx /= gcd;
                dy /= gcd;
                String slope = dx + "#" + dy;
                if (!map.containsKey(slope)) {
                    map.put(slope, 1);
                } else {
                    map.put(slope, map.get(slope) + 1);
                }
                max = Math.max(max, map.get(slope));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }

    private int generateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        else return generateGCD(b, a % b);
    }
}
