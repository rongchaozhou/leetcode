
class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i].start, i);
        }
        int[] res = new int[intervals.length];
        for (int i = 0; i < res.length; i++) {
            Integer k = map.ceilingKey(intervals[i].end);
            if (k == null) res[i] = -1;
            else res[i] = map.get(k);
        }
        return res;
    }
}
