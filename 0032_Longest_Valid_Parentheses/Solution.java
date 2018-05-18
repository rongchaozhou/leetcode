class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && !stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                stack.pop();
            } else {
                stack.push(i);
            }
        }
        int last = s.length(), max = 0;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            max = Math.max(max, last - curr - 1);
            last = curr;
        }
        max = Math.max(max, last);
        return max;
    }
}
