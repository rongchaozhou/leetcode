import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        helper(res, list, root, sum);
        return res;
    }

    public void helper(List<List<Integer>> res, LinkedList<Integer> currList, TreeNode currNode, int sum) {
        if (currNode == null) return;
        currList.add(currNode.val);
        if (currNode.left == null && currNode.right == null && currNode.val == sum) {
            res.add(new LinkedList<>(currList));
            currList.removeLast();
            return;
        } else {
            helper(res, currList, currNode.left, sum - currNode.val);
            helper(res, currList, currNode.right, sum - currNode.val);
        }
        currList.removeLast();
    }
}
