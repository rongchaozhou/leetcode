class Solution {
    public int jump(int[] nums) {
        int level = 0, level_Left = 0, level_Right = 0;
        while(level_Right < nums.length - 1) {
            level++;
            int duumy_Right = level_Right;
            for(int i = level_Left; i <= duumy_Right; i++) {
                level_Right = Math.max(level_Right, i+nums[i]);
            }
            level_Left = duumy_Right + 1;
        }
        return level;
    }
}
