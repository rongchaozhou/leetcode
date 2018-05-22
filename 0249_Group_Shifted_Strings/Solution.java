class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String root = shift(s);
            if (!map.containsKey(root)) {
                map.put(root, new ArrayList<>());
            }
            map.get(root).add(s);
        }
        List<List<String>> res = new LinkedList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }

    private String shift(String s) {
        if (s.charAt(0) == 'a') return s;
        char[] chars = s.toCharArray();
        int len = 'z' + 1 - s.charAt(0);
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) ('a' + (chars[i] + len - 'a') % 26);
        }
        return new String(chars);
    }
}
