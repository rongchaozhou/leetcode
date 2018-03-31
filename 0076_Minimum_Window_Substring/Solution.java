class Solution {
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        int[] letter = new int[256];
        int cnt = t.length();
        for (char c : tt) {
            letter[c]++;
        }
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        while (end < ss.length) {
            if (letter[ss[end]] > 0) {
                cnt--;
            }
            letter[ss[end]]--;
            while (cnt == 0) {
                if (end - start + 1 < min) {
                    min = end - start + 1;
                    res = s.substring(start, end + 1);
                }
                if (letter[ss[start]] == 0) {
                    cnt++;
                }
                letter[ss[start]]++;
                start++;
            }
            end++;
        }
        return res;
    }
}
