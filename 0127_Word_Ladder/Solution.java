import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> q = new LinkedList<>();
        q.add(beginWord);
        int ans = 1;
        while(q.size() != 0){
            int t = q.size();
            while(t-- > 0) {
                String temp = q.remove();
                if (temp.equals(endWord)) return ans;
                for (int i = 0; i < wordList.size(); i++) {
                    if (isOneDiff(wordList.get(i), temp)) {
                        q.add(wordList.remove(i--));
                    }
                }
            }
            ans++;
        }
        return 0;
    }
    public boolean isOneDiff(String a, String b){
        int counter = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) counter++;
        }
        return counter == 1;
    }
}