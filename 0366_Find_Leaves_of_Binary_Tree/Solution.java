class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        traverse(root, res);
        return res;
    }

    private int traverse(TreeNode root, List<List<Integer>> res) {
        if (root == null) return 0;
        int height = 1 + Math.max(traverse(root.left, res), traverse(root.right, res));
        if (res.size() < height) res.add(new LinkedList<>());
        res.get(height - 1).add(root.val);
        return height;
    }
}
