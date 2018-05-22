class RandomizedCollection {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rdm;

    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rdm = new Random();
    }

    public boolean insert(int val) {
        int index = list.size();
        list.add(val);
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<>());
            map.get(val).add(index);
            return true;
        } else {
            map.get(val).add(index);
            return false;
        }
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val).iterator().next(), length = list.size();
        map.get(val).remove(index);
        // remove index first in case last == val
        if (index != length - 1) {
            int last = list.get(length - 1);
            map.get(last).remove(length - 1);
            map.get(last).add(index);
            list.set(index, last);
        }
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        list.remove(length - 1);
        return true;

    }

    public int getRandom() {
        return list.get(rdm.nextInt(list.size()));
    }
}

