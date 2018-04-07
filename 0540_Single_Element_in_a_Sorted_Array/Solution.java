class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == nums[mid - 1]) {
                if ((mid - lo + 1) % 2 == 0) {
                    lo = mid + 1;
                } else {
                    hi = mid - 2;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if ((hi - mid + 1) % 2 == 0) {
                    hi = mid - 1;
                } else {
                    lo = mid + 2;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }
}
