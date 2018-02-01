import java.util.*;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++) {
            int toSearch = target - nums[i];
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi) {
                if(nums[lo] + nums[hi] == toSearch) {
                    return target;
                }
                int tempSum = nums[lo] + nums[hi];
                ans = Math.abs(tempSum - toSearch) < Math.abs(ans - target) ? tempSum + nums[i] : ans;
                if(tempSum > toSearch) {
                    hi--;
                }else {
                    lo ++;
                }
            }
        }
        return ans;
    }
}
