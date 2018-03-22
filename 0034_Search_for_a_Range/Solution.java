class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int leftIndex = 0, hi = nums.length - 1;
        while (leftIndex < hi) {
            int mid = (leftIndex + hi) / 2;
            if (nums[mid] < target) {
                leftIndex = mid + 1;
            } else if (nums[mid] == target) {
                hi = mid;
            } else {
                hi = mid - 1;
            }
        }
        if (nums[leftIndex] != target) return new int[]{-1, -1};
        int lo = leftIndex, rightIndex = nums.length - 1;
        while (lo < rightIndex) {
            int mid = (lo + rightIndex + 1) / 2;
            if (nums[mid] == target) {
                lo = mid;
            } else {
                rightIndex = mid - 1;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }
}
