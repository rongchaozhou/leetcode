class Solution {
    int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private boolean helper(TreeNode root) {
        boolean left = root.left == null || helper(root.left) && root.val == root.left.val;
        boolean right = root.right == null || helper(root.right) && root.val == root.right.val;
        if (left && right) {
            res++;
            return true;
        }
        return false;
    }
}
