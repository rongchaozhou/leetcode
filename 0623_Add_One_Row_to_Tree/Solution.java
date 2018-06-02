class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        helper(root, d - 2, v);
        return root;
    }

    private void helper(TreeNode node, int depth, int v) {
        if (node == null) return;
        if (depth == 0) {
            TreeNode nodeLeft = new TreeNode(v);
            TreeNode nodeRight = new TreeNode(v);
            nodeLeft.left = node.left;
            nodeRight.right = node.right;
            node.left = nodeLeft;
            node.right = nodeRight;
            return;
        }
        helper(node.left, depth - 1, v);
        helper(node.right, depth - 1, v);
    }
}
