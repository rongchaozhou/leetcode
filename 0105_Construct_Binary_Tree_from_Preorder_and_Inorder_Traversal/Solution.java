class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int index = 0; // find the index of preorder[0] in inorder
        while (inorder[index] != preorder[0]) {
            index++;
        }
        int[] preorderLeft = new int[index];
        int[] inorderLeft = new int[index];
        for (int i = 0; i < index; i++) {
            preorderLeft[i] = preorder[i + 1];
            inorderLeft[i] = inorder[i];
        }
        int[] preorderRight = new int[length - index - 1];
        int[] inorderRight = new int[length - index - 1];
        for (int i = 0; i < length - index - 1; i++) {
            preorderRight[i] = preorder[i + index + 1];
            inorderRight[i] = inorder[i + index + 1];
        }
        root.left = buildTree(preorderLeft, inorderLeft);
        root.right = buildTree(preorderRight, inorderRight);
        return root;
    }
}
