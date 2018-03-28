import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0) {
            return false;
        }
        Map<Long, Long> buckets = new HashMap<>();
        long divisor = (long)t + 1;
        for(int i = 0; i < nums.length; i++) {
            long bucketID = getID(nums[i], divisor);
            if(i > k) {
                buckets.remove(getID(nums[i-k-1], divisor));
            }
            if(buckets.containsKey(bucketID)) {
                return true;
            }
            //note that every bucket contains no more than one element;
            if(buckets.containsKey(bucketID - 1) && Math.abs(buckets.get(bucketID - 1) - nums[i]) < divisor) {
                return true;
            }
            if(buckets.containsKey(bucketID + 1) && Math.abs(buckets.get(bucketID + 1) - nums[i]) < divisor) {
                return true;
            }
            buckets.put(bucketID, (long)nums[i]);
        }
        return false;
    }
    private long getID(long x, long divisor) {
        return x < 0 ? (x + 1) / divisor - 1 : x / divisor;
    }
}
