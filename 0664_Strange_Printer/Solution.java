class Solution {
    public int strangePrinter(String s) {
        if (s == null || s.length() == 0) return 0;
        s = abbrev(s);
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int min = dp[i][j - 1] + 1;
                for (int k = i; k <= j - 2; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        min = Math.min(min, dp[i][k] + dp[k + 1][j - 1]);
                    }
                }
                dp[i][j] = min;
            }
        }
        return dp[0][len - 1];
    }

    private String abbrev(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            while (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(i)) i++;
        }
        return sb.toString();
    }
}
