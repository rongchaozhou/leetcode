public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        Random random = new Random();
        while (lo < hi) {
            int pivot = lo + random.nextInt(hi - lo + 1);
            int index = partition(nums, lo, hi, pivot);
            if (index > target) {
                hi = index - 1;
            } else if (index < target) {
                lo = index + 1;
            } else break;
        }
        return nums[target];
    }

    private int partition(int[] nums, int lo, int hi, int pivot) {
        int pivotValue = nums[pivot];
        swap(nums, hi, pivot);
        int storeIndex = lo;
        for (int i = lo; i <= hi - 1; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, hi, storeIndex);
        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
