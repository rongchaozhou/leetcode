class Solution {
    int res;

    public int closestValue(TreeNode root, double target) {
        res = root.val;
        traverse(root, target);
        return res;
    }

    public void traverse(TreeNode root, double target) {
        if (root.left != null) traverse(root.left, target);
        if (root.right != null) traverse(root.right, target);
        if (Math.abs(root.val - target) < Math.abs(res - target)) res = root.val;
    }
}
