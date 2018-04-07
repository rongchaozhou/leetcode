class WordDistance {
    HashMap<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (map.containsKey(word)) {
                map.get(word).add(i);
            } else {
                map.put(word, new LinkedList<Integer>(Arrays.asList(i)));
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int shortest = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ) {
            int index1 = list1.get(i), index2 = list2.get(j);
            if (index1 < index2) {
                shortest = Math.min(shortest, index2 - index1);
                i++;
            } else {
                shortest = Math.min(shortest, index1 - index2);
                j++;
            }
        }
        return shortest;
    }
}
