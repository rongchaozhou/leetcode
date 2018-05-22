class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        int i = 0, j = 0, len = S.length();
        List<List<Integer>> res = new LinkedList<>();
        while (i < len) {
            while (j < len && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            if (j - i >= 3) {
                res.add(Arrays.asList(i, j - 1));
            }
            i = j;
        }
        return res;
    }
}
