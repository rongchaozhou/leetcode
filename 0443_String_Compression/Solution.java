class Solution {
    public int compress(char[] chars) {
        int archor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read == chars.length - 1 || chars[read + 1] != chars[read]) {
                chars[write++] = chars[archor];
                if (read != archor) {
                    for (char c : ("" + (read - archor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                archor = read + 1;
            }
        }
        return write;
    }
}
