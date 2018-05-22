class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> col = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        col.offer(0);
        int min = 0, max = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int column = col.poll();
            min = Math.min(min, column);
            max = Math.max(max, column);
            if (!map.containsKey(column)) map.put(column, new LinkedList<>());
            map.get(column).add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
                col.offer(column - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                col.offer(column + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
