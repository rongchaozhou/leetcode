class Solution {
    public List<String> findStrobogrammatic(int n) {
        LinkedList<String> list = new LinkedList<>();
        if (n % 2 == 1) {
            list.addAll(Arrays.asList("0", "1", "8"));
            n--;
        } else {
            list.add("");
        }
        while (n > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String s = list.poll();
                list.offer("6" + s + "9");
                list.offer("9" + s + "6");
                list.offer("1" + s + "1");
                list.offer("8" + s + "8");
                if (n != 2) {
                    list.offer("0" + s + "0");
                }
            }
            n -= 2;
        }
        return list;
    }
}
