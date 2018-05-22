class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new LinkedList<>();
        backtracking(res, word, new StringBuilder(), 0, 0);
        return res;
    }

    private void backtracking(List<String> res, String word, StringBuilder sb, int pos, int cnt) {
        int len = sb.length();
        if (pos == word.length()) {
            if (cnt > 0) sb.append(cnt);
            res.add(sb.toString());
        } else {
            backtracking(res, word, sb, pos + 1, cnt + 1);
            if (cnt > 0) sb.append(cnt);
            backtracking(res, word, sb.append(word.charAt(pos)), pos + 1, 0);
        }
        sb.setLength(len);
    }
}
