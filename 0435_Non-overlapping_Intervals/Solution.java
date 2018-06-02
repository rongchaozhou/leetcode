class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.end != o2.end) return o1.end - o2.end;
                return o2.start - o1.start;
            }
        });
        int cnt = 1;
        int end = intervals[0].end;
        for (Interval interval : intervals) {
            if (interval.start >= end) {
                cnt++;
                end = interval.end;
            }
        }
        return intervals.length - cnt;
    }
}
