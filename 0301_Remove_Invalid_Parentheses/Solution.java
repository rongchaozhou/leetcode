class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        dfs(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }

    private void dfs(List<String> res, String s, int i, int last_j, char[] paren) {
        int cnt = 0;
        while (i < s.length()) {
            if (s.charAt(i) == paren[0]) cnt++;
            if (s.charAt(i) == paren[1]) cnt--;
            if (cnt >= 0) {
                i++;
                continue;
            }
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == paren[1] && (j == last_j || s.charAt(j - 1) != paren[1])) {
                    dfs(res, s.substring(0, j) + s.substring(j + 1), i, j, paren);
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (paren[0] == '(') {
            dfs(res, reversed, 0, 0, new char[]{')', '('});
        } else {
            res.add(reversed);
        }
    }
}
