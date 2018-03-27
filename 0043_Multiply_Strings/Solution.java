class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        num1 = (new StringBuilder(num1)).reverse().toString();
        num2 = (new StringBuilder(num2)).reverse().toString();
        for (int i = 0; i < num1.length() + num2.length() - 1 || carry != 0; i++) {
            if (i < num1.length() + num2.length() - 1) {
                for (int j = 0; j < num1.length(); j++) {
                    if (i - j >= 0 && i - j < num2.length()) {
                        carry += (num1.charAt(j) - '0') * (num2.charAt(i - j) - '0');
                    }
                }
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
