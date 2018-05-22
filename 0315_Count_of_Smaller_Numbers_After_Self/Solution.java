class Solution {
    class BSTNode {
        int val, sum, dup; // sum records the number of smaller element left to the current
        BSTNode left, right;

        public BSTNode(int value) {
            val = value;
            sum = 0; // because we read from right to left
            dup = 1;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) return new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        BSTNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(res, root, nums[i], 0);
        }
        return res;
    }

    private BSTNode insert(LinkedList<Integer> list, BSTNode root, int num, int preSum) {
        if (root == null) {
            root = new BSTNode(num);
            list.addFirst(preSum);
        } else if (root.val < num) {
            root.right = insert(list, root.right, num, preSum + root.sum + root.dup);
        } else if (root.val > num) {
            root.sum++;
            root.left = insert(list, root.left, num, preSum);
        } else if (root.val == num) {
            root.dup++;
            list.addFirst(preSum + root.sum);
        }
        return root;
    }
}
