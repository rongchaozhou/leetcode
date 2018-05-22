class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int k : nums) {
            if (!map.containsKey(k)) {
                int leftLength = map.containsKey(k - 1) ? map.get(k - 1) : 0;
                int rightLength = map.containsKey(k + 1) ? map.get(k + 1) : 0;
                int sum = leftLength + rightLength + 1;
                res = Math.max(res, sum);
                map.put(k, sum);
                map.put(k - leftLength, sum);
                map.put(k + rightLength, sum);
            } else {
                continue;
            }
        }
        return res;
    }
}
