class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int j = 1; j <= n; j++) {
            int i = k / factorial[n - j];
            k %= factorial[n - j];
            sb.append(list.get(i));
            list.remove(i);
        }
        return sb.toString();
    }
}
