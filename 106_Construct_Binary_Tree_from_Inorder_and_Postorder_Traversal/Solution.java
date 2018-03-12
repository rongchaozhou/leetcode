class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        if (length == 0) return null;
        TreeNode root = new TreeNode(postorder[length - 1]);
        int index = 0; // find the index of postorder[length - 1] in inorder
        while (inorder[index] != postorder[length - 1]) {
            index++;
        }
        int[] inorderLeft = new int[index];
        int[] postorderLeft = new int[index];
        for (int i = 0; i < index; i++) {
            postorderLeft[i] = postorder[i];
            inorderLeft[i] = inorder[i];
        }
        int[] inorderRight = new int[length - index - 1];
        int[] postorderRight = new int[length - index - 1];
        for (int i = 0; i < length - index - 1; i++) {
            postorderRight[i] = postorder[index + i];
            inorderRight[i] = inorder[i + index + 1];
        }
        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);
        return root;
    }
}
