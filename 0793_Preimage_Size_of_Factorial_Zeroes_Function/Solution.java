class Solution {
    public int preimageSizeFZF(int K) {
        if (K < 5) return 5;
        int d = 1;
        while (d * 5 + 1 <= K) {
            d = d * 5 + 1;
        }
        if (K / d == 5) return 0;
        return preimageSizeFZF(K % d);
    }
}
