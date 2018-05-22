class Solution {
    public char findTheDifference(String s, String t) {
        int c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            c = c - s.charAt(i) + t.charAt(i);
        }
        return (char) c;
    }
}
