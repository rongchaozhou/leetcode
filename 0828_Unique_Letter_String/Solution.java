class Solution {
    public int uniqueLetterString(String S) {
        long res = 0, d = 1000000007;
        for (int i = 0; i < S.length(); i++) {
            int left = 1, right = 1;
            while (i - left >= 0 && S.charAt(i - left) != S.charAt(i)) {
                left++;
            }
            while (i + right < S.length() && S.charAt(i + right) != S.charAt(i)) {
                right++;
            }
            res = (res + left * right) % d;
        }
        return (int) res;
    }
}
