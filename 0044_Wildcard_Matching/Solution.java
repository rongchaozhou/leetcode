class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }
        for (int j = 1; j <= p.length(); j++) {
            for (int i = 1; i <= s.length(); i++) {
                if (p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1];
                    int k = i - 1;
                    while (dp[i][j] == false && k >= 0) {
                        dp[i][j] = dp[k][j - 1];
                        k--;
                    }
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1)));
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
