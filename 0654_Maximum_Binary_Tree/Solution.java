class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end) return null;
        int max_index = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[max_index]) {
                max_index = i;
            }
        }
        TreeNode root = new TreeNode(nums[max_index]);
        root.left = construct(nums, start, max_index - 1);
        root.right = construct(nums, max_index + 1, end);
        return root;
    }
}
