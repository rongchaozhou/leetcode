class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer[]> range = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
                range.get(nums[i])[1] = i;
            } else {
                count.put(nums[i], 1);
                range.put(nums[i], new Integer[]{i, i});
            }
        }
        int maxFrequency = 0;
        int shortest = Integer.MAX_VALUE;
        for (Integer i : count.keySet()) {
            if (count.get(i) > maxFrequency) {
                maxFrequency = count.get(i);
                shortest = range.get(i)[1] - range.get(i)[0] + 1;
            } else if (count.get(i) == maxFrequency) {
                shortest = Math.min(shortest, range.get(i)[1] - range.get(i)[0] + 1);
            }
        }
        return shortest;
    }
}
