class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        for (int hh = 0; hh < 12; hh++) {
            for (int mm = 0; mm < 60; mm++) {
                if (Integer.bitCount(hh) + Integer.bitCount(mm) == num) {
                    res.add(String.format("%d:%02d", hh, mm));
                }
            }
        }
        return res;
    }
}
