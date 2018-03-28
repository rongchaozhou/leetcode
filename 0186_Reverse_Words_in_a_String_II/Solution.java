class Solution {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int lo = 0;
        for (int i = 1; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, lo, i - 1);
                lo = i + 1;
            }
        }
        reverse(str, lo, str.length - 1);
    }

    public void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
