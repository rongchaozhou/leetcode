class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int k : nums1) {
            int v = map1.getOrDefault(k, 0);
            map1.put(k, v + 1);
        }
        int cnt = 0;
        for (int k : nums2) {
            if (map1.keySet().contains(k)) {
                int v = map2.getOrDefault(k, 0);
                if (v < map1.get(k)) {
                    map2.put(k, v + 1);
                    cnt++;
                }
            }
        }
        int[] res = new int[cnt];
        int index = 0;
        for (int k : map2.keySet()) {
            for (int i = map2.get(k); i > 0; i--) {
                res[index++] = k;
            }
        }
        return res;
    }
}
