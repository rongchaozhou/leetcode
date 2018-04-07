class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, subMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= subMin) {
                subMin = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
