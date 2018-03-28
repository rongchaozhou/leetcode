class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        if (root.left == null) {
            flatten(root.right);
        }
        flatten(root.left);
        TreeNode left = root.left;
        flatten(root.right);
        TreeNode right = root.right;
        TreeNode leftEnd = left;
        while (leftEnd.right != null) {
            leftEnd = leftEnd.right;
        }
        root.left = null;
        root.right = left;
        leftEnd.right = right;
    }
}
