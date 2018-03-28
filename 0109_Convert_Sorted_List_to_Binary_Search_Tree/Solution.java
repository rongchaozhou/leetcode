class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode search = head;
        while(search != null) {
            search = search.next;
            length++;
        }
        search = head;
        int[] nums = new int[length];
        int index = 0;
        while (search != null) {
            nums[index] = search.val;
            index++;
            search = search.next;
        }
        return helper(nums, 0, length);
    }
    public TreeNode helper(int[] nums, int start, int end) { //start include, end not include
        if(start == end) return null;
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid);
        root.right = helper(nums, mid+1, end);
        return root;
    }
}