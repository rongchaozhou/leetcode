import java.util.*;

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Queue<Integer[]>> map = new HashMap<>();
        for(char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<Integer[]>());
        }
        for(int i = 0; i < words.length; i++) {
            map.get(words[i].charAt(0)).offer(new Integer[] {i, 0}); //1st for index in words, 2nd for index to check in words[i]
        }
        int count = 0;
        for(char c : S.toCharArray()) {
            Queue<Integer[]> queue = map.get(c);
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Integer[] curr = queue.poll();
                if(curr[1] == words[curr[0]].length() - 1) {
                    count++;
                }else {
                    char nextChar = words[curr[0]].charAt(curr[1] + 1);
                    map.get(nextChar).offer(new Integer[] {curr[0], curr[1] + 1});
                }
            }
        }
        return count;
    }
}