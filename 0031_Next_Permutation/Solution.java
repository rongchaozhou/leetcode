class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i != -1) {
            int j = i + 1;
            while (j + 1 < nums.length && nums[j + 1] > nums[i]) {
                j++;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    private void reverse(int[] num, int i, int j) {
        while (i < j) {
            swap(num, i, j);
            i++;
            j--;
        }
    }
}
