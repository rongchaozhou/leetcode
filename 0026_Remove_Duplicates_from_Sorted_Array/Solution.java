class Solution {
    public int removeDuplicates(int[] nums) {
        int numOfNotDup = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[numOfNotDup - 1]) {
                nums[numOfNotDup] = nums[i];
                numOfNotDup++;
            }
        }
        return numOfNotDup;
    }
}
