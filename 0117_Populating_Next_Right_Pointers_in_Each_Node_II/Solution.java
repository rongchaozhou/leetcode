/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 * int val;
 * TreeLinkNode left, right, next;
 * TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode preHead = new TreeLinkNode(0);
        while (root != null) {
            TreeLinkNode currNode = preHead;
            while (root != null) {
                if (root.left != null) {
                    currNode.next = root.left;
                    currNode = currNode.next;
                }
                if (root.right != null) {
                    currNode.next = root.right;
                    currNode = currNode.next;
                }
                root = root.next;
            }
            root = preHead.next;
            preHead.next = null;
        }
    }
}
