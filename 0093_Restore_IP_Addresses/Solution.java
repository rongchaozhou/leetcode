class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new LinkedList<>();
        for (int length1 = 1; length1 <= 3; length1++) {
            for (int length2 = 1; length2 <= 3; length2++) {
                for (int length3 = 1; length3 <= 3; length3++) {
                    for (int length4 = 1; length4 <= 3; length4++) {
                        if (length1 + length2 + length3 + length4 == s.length()) {
                            String s1 = s.substring(0, length1);
                            String s2 = s.substring(length1, length1 + length2);
                            String s3 = s.substring(length1 + length2, length1 + length2 + length3);
                            String s4 = s.substring(length1 + length2 + length3);
                            if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                                list.add(s1 + '.' + s2 + '.' + s3 + '.' + s4);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    private boolean isValid(String s) {
        if (s.length() != 1 && s.charAt(0) == '0' || Integer.valueOf(s) > 255) {
            return false;
        }
        return true;
    }
}
