import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> level = new LinkedList<>();
        if (root != null) {
            level.offer(root);
        }
        while (!level.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = level.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = level.poll();
                list.add(node.val);
                if (node.left != null) {
                    level.offer(node.left);
                }
                if (node.right != null) {
                    level.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
