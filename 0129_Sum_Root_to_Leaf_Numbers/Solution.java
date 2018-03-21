class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    public int sum(TreeNode root, int lastSum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return lastSum * 10 + root.val;
        return sum(root.left, lastSum * 10 + root.val) + sum(root.right, lastSum * 10 + root.val);
    }
}
