class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        for (int k : nums) {
            maxValue = Math.max(maxValue, k);
            minValue = Math.min(minValue, k);
        }

        if (maxValue == minValue) {
            return 0;
        }

        int aveGap = (int) Math.ceil((double) (maxValue - minValue) / (nums.length - 1));
        int[] bucketMax = new int[nums.length];
        int[] bucketMin = new int[nums.length];
        Arrays.fill(bucketMax, Integer.MIN_VALUE);
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        for (int k : nums) {
            int index = (k - minValue) / aveGap;
            bucketMax[index] = Math.max(bucketMax[index], k);
            bucketMin[index] = Math.min(bucketMin[index], k);
        }

        int maxGap = Integer.MIN_VALUE;
        int lastMax = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (bucketMax[i] != Integer.MIN_VALUE) {
                maxGap = Math.max(maxGap, bucketMin[i] - lastMax);
                lastMax = bucketMax[i];
            }
        }
        return maxGap;
    }
}
