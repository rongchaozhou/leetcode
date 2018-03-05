class Solution {
    public int numTilings(int N) {
        int last = 0, curr = 1, next = 1, mod = 1000000007;
        while (N > 0) {
            int next2 = ((2 * next % mod) + last) % mod;
            last = curr;
            curr = next;
            next = next2;
            N--;
        }
        return curr;
    }
}
