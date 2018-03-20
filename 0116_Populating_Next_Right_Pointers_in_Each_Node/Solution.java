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
        if (root == null) return;
        TreeLinkNode levelHead = root;
        while (levelHead.left != null) {
            TreeLinkNode currNode = levelHead;
            while (currNode != null) {
                currNode.left.next = currNode.right;
                if (currNode.next != null) {
                    currNode.right.next = currNode.next.left;
                }
                currNode = currNode.next;
            }
            levelHead = levelHead.left;
        }
    }
}
