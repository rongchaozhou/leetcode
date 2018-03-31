class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] < heights[i]) {
                stack.push(i);
            } else if (heights[stack.peek()] > heights[i]) {
                int j = -1;
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    j = stack.pop();
                    max = Math.max(max, heights[j] * (i - j));
                }
                heights[j] = heights[i];
                stack.push(j);
            }
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            max = Math.max(max, heights[j] * (heights.length - j));
        }
        return max;
    }
}
