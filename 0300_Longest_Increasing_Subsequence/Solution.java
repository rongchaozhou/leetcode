class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int k : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < k) i = m + 1;
                else j = m;
            }
            tails[i] = k;
            if (i == size) size++;
        }
        return size;
    }
}
