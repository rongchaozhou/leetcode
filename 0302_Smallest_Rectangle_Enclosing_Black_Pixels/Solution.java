class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int upper = search(image, 0, x, 0, n, false, true);
        int bottom = search(image, x + 1, m, 0, n, false, false);
        int left = search(image, 0, y, upper, bottom, true, true);
        int right = search(image, y + 1, n, upper, bottom, true, false);
        return (bottom - upper) * (right - left);

    }

    private int search(char[][] image, int lo, int hi, int min, int max, boolean horizontal, boolean goLo) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            boolean hasBlack = false;
            for (int i = min; i < max; i++) {
                if ((horizontal ? image[i][mid] : image[mid][i]) == '1') {
                    hasBlack = true;
                    break;
                }
            }
            if (hasBlack == goLo) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
