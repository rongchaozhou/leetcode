class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int size = 0;
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && i < k + size && stack.peek() > num.charAt(i)) {
                stack.pop();
                size--;
            }
            if (size < num.length() - k) {
                stack.push(num.charAt(i));
                size++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        int i = 0;
        while (sb.length() > i && sb.charAt(i) == '0') {
            i++;
        }
        sb.delete(0, i);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
