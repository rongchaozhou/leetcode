class Solution {
    public int rob(TreeNode root) {
        int[] rob = helper(root);
        return Math.max(rob[0], rob[1]);
    }

    private int[] helper(TreeNode node) {
        if (node == null) return new int[2];
        int[] rob = new int[2];
        int[] robLeft = helper(node.left);
        int[] robRight = helper(node.right);
        rob[0] = node.val + robLeft[1] + robRight[1];
        rob[1] = Math.max(robLeft[0], robLeft[1]) + Math.max(robRight[0], robRight[1]);
        return rob;
    }
}
