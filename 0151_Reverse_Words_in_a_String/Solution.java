public class Solution {
    public String reverseWords(String s) {
        String[] parts = s.trim().split(" +");
        String ans = parts[parts.length - 1];
        for (int i = parts.length - 2; i >= 0; i--) {
            ans += " " + parts[i];
        }
        return ans;
    }
}
