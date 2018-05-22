class Solution {
    public String maskPII(String S) {
        String[] country = {"", "+*-", "+**-", "+***-"};
        int index = S.indexOf('@');
        if (index > 0) {
            return (S.charAt(0) + "*****" + S.substring(index - 1)).toLowerCase();
        }
        S = S.replaceAll("[^0-9]", "");
        return country[S.length() - 10] + "***-***-" + S.substring(S.length() - 4);
    }
}
