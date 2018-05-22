class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0, sum = 0, min = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                min = Math.min(min, j - i + 1);
                i++;
                sum -= nums[i];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
