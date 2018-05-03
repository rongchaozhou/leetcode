class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> map;
    Random rdm;

    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        rdm = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, map.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val), length = nums.size();
        if (index != length - 1) {
            int last = nums.get(length - 1);
            map.put(last, index);
            nums.set(index, last);
        }
        map.remove(val);
        nums.remove(length - 1);
        return true;
    }

    public int getRandom() {
        return nums.get(rdm.nextInt(nums.size()));
    }
}
