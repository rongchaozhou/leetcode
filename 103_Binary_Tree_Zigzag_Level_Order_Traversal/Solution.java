import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> level = new LinkedList<>();
        boolean direction = true; // true for left -> right
        if (root != null) {
            level.offer(root);
        }
        while (!level.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int size = level.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = level.poll();
                if (direction) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    level.offer(node.left);
                }
                if (node.right != null) {
                    level.offer(node.right);
                }
            }
            res.add(list);
            direction = !direction;
        }
        return res;
    }
}
