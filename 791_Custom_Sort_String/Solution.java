class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        int[] counter = new int[26];
        for (int i = 0; i < T.length(); i++) {
            counter[T.charAt(i) - 'a']++;
        }
        for (int i = 0; i < S.length(); i++) {
            while (counter[S.charAt(i) - 'a'] > 0) {
                sb.append(S.charAt(i));
                counter[S.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < counter.length; i++) {
            while (counter[i] > 0) {
                sb.append((char) ('a' + i));
                counter[i]--;
            }
        }
        return sb.toString();
    }
}
