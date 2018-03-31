class Solution {
    public void sortColors(int[] nums) {
        int[] bucket = new int[3];
        for (int i : nums) {
            bucket[i]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < bucket[0]) {
                nums[i] = 0;
            } else if (i < bucket[0] + bucket[1]) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
