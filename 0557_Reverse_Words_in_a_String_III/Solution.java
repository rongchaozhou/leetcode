class Solution {
    public String reverseWords(String s) {
        String[] parts = s.split(" ");
        StringBuilder sb = new StringBuilder(parts[0]).reverse();
        for (int i = 1; i < parts.length; i++) {
            sb.append(" " + new StringBuilder(parts[i]).reverse().toString());
        }
        return sb.toString();
    }
}
