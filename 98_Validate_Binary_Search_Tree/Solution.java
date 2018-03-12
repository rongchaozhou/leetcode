class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, (long) Integer.MAX_VALUE + 1, (long) Integer.MIN_VALUE - 1);
    }

    public boolean helper(TreeNode root, long max, long min) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return helper(root.left, root.val, min) && helper(root.right, max, root.val);
    }
}
