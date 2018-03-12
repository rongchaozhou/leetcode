class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricII(root.left, root.right);
    }

    public boolean isSymmetricII(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isSymmetricII(left.left, right.right) && isSymmetricII(left.right, right.left);
    }
}
