class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                res.addAll(threeSum(nums, i, target));
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, int index, int target) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = index + 1; i < nums.length - 2; i++) {
            if (i == index + 1 || nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = nums.length - 1, sum = target - nums[i] - nums[index];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[index], nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo + 1] == nums[lo]) lo++;
                        while (hi > lo && nums[hi - 1] == nums[hi]) hi--;
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }
}
