import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi) {
                if(nums[lo] + nums[hi] == target - nums[i]) {
                    return target;
                }
                ans = Math.abs(target - nums[lo] - nums[hi] - nums[i]) < Math.abs(ans - target) ? nums[lo] + nums[hi] + nums[i] : ans;
                if(nums[lo] + nums[hi] > target - nums[i]) {
                    hi--;
                }else {
                    lo++;
                }
            }
        }
        return ans;
    }
}
