class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else return o2[1] - o1[1];
            }
        });

        int[] nums = new int[envelopes.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = envelopes[i][1];
        }
        return lengthOfLIS(nums);
    }

    //leetcode problem 300 Longest Increasing Subsequence
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
