class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int x_min = Integer.MAX_VALUE, y_min = Integer.MAX_VALUE, x_max = -1, y_max = -1, sum = 0;
        HashSet<String> set = new HashSet<>();
        for (int[] rect : rectangles) {
            int x0 = rect[0], y0 = rect[1], x1 = rect[2], y1 = rect[3];
            sum += (x1 - x0) * (y1 - y0);
            x_min = Math.min(x_min, x0);
            y_min = Math.min(y_min, y0);
            x_max = Math.max(x_max, x1);
            y_max = Math.max(y_max, y1);
            String[] indices = {x0 + "#" + y0, x0 + "#" + y1, x1 + "#" + y0, x1 + "#" + y1};
            for (String indice : indices) {
                if (!set.add(indice)) {
                    set.remove(indice);
                }
            }
        }
        return (x_max - x_min) * (y_max - y_min) == sum && set.size() == 4 && set.contains(x_min + "#" + y_min)
                && set.contains(x_min + "#" + y_max) && set.contains(x_max + "#" + y_min)
                && set.contains(x_max + "#" + y_max);
    }
}
