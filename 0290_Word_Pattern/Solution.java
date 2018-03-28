class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] parts = str.split(" ");
        if (pattern.length() != parts.length) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            if (map.keySet().contains(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(parts[i])) {
                    return false;
                }
            } else {
                if (map.values().contains(parts[i])) {
                    return false;
                } else {
                    map.put(pattern.charAt(i), parts[i]);
                }
            }
        }
        return true;
    }
}
