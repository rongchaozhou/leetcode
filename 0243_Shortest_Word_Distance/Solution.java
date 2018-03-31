class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int lastWord1 = -1, lastWord2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (lastWord2 != -1) {
                    res = Math.min(res, i - lastWord2);
                }
                lastWord1 = i;
            } else if (words[i].equals(word2)) {
                if (lastWord1 != -1) {
                    res = Math.min(res, i - lastWord1);
                }
                lastWord2 = i;
            }
        }
        return res;
    }
}
