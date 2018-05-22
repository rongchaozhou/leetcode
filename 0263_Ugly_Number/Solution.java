class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        int[] factors = {2, 3, 5};
        for (int i : factors) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }
}
