class NumArray {
    int[] sum;

    public NumArray(int[] nums) {
        this.sum = nums;
        for (int i = 1; i < sum.length; i++) {
            sum[i] += sum[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return sum[j];
        return sum[j] - sum[i - 1];
    }
}
