class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] pointer = new int[primes.length];
        for (int i = 1; i < n; i++) {
            int next = Integer.MAX_VALUE;
            for (int k = 0; k < primes.length; k++) {
                next = Math.min(next, ugly[pointer[k]] * primes[k]);
            }
            ugly[i] = next;
            for (int k = 0; k < primes.length; k++) {
                if (next == ugly[pointer[k]] * primes[k]) pointer[k]++;
            }
        }
        return ugly[n - 1];
    }
}
