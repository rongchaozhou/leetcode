class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        long lo = lower;
        List<String> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == lo + 1) {
                list.add("" + lo);
            } else if (nums[i] > lo + 1) {
                list.add("" + lo + "->" + (nums[i] - 1));
            }
            lo = (long) nums[i] + 1;
        }
        if (lo == upper) {
            list.add("" + upper);
        } else if (lo < upper) {
            list.add("" + lo + "->" + upper);
        }
        return list;
    }
}
