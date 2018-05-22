class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int curr = 0, res = 0;
        for (int i = 2; i < A.length; i++) {
            if (2 * A[i - 1] == A[i - 2] + A[i]) {
                curr++;
                res += curr;
            } else {
                curr = 0;
            }
        }
        return res;
    }
}
