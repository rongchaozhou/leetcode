class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (Character.isLowerCase(abbr.charAt(j))) {
                if (word.charAt(i) == abbr.charAt(j)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            } else if (abbr.charAt(j) > '0' && abbr.charAt(j) <= '9') {
                int start = j;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    j++;
                }
                int num = Integer.valueOf(abbr.substring(start, j));
                i += num;
            } else {
                return false;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
