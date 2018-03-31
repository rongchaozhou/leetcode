class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root != null) {
            backtracking(res, root, "" + root.val);
        }
        return res;
    }

    private void backtracking(List<String> res, TreeNode curr, String path) {
        if (curr.left == null && curr.right == null) {
            res.add(path);
        }
        if (curr.left != null) {
            backtracking(res, curr.left, path + "->" + curr.left.val);
        }
        if (curr.right != null) {
            backtracking(res, curr.right, path + "->" + curr.right.val);
        }
    }
}
