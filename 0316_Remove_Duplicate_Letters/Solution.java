class Solution {
    public String removeDuplicateLetters(String s) {
        HashSet<Character> letter = new HashSet<>(26);
        for (char c : s.toCharArray()) letter.add(c);
        StringBuilder sb = new StringBuilder();
        int lastPos = -1;
        while (letter.size() > 0) {
            HashSet<Character> curr = new HashSet<>();
            int pos = s.length() - 1;
            //search from right till we find all remaining char once
            for (; pos >= 0; pos--) {
                if (letter.contains(s.charAt(pos))) {
                    curr.add(s.charAt(pos));
                    if (curr.size() == letter.size()) break;
                }
            }
            for (int i = pos - 1; i > lastPos; i--) {
                if (letter.contains(s.charAt(i)) && s.charAt(i) <= s.charAt(pos)) pos = i;
            }
            sb.append(s.charAt(pos));
            letter.remove(s.charAt(pos));
            lastPos = pos;
        }
        return sb.toString();
    }
}
