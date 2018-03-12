/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<TreeNode>();
        List<TreeNode>[] dp = new List[n + 1];
        for(int i = 0; i < n + 1; i++) {
            dp[i] = new LinkedList<>();
        }
        dp[0].add(null);
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j <= i; j++) {
                for(TreeNode left : dp[j - 1]) {
                    for(TreeNode right : dp[i - j]) {
                        TreeNode root = new TreeNode(j);
                        root.left = createCopyTreeWithIncre(left, 0);
                        root.right = createCopyTreeWithIncre(right, j);
                        dp[i].add(root);
                    }
                }
            }
        }
        return dp[n];
    }
    public TreeNode createCopyTreeWithIncre(TreeNode originRoot, int increment) {
        if(originRoot == null) return null;
        TreeNode copy = new TreeNode(originRoot.val + increment);
        copy.left = createCopyTreeWithIncre(originRoot.left, increment);
        copy.right = createCopyTreeWithIncre(originRoot.right, increment);
        return copy;
    }
}
