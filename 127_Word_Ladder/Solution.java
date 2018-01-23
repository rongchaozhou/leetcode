import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> q = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        q.add(beginWord);
        ans.add(1);
        while(q.size() != 0){
            String temp = q.remove();
            int aannss = ans.remove();
            if(temp.equals(endWord)) return aannss;
            for(int i = 0; i < wordList.size(); i++){
                if(isonediffer(wordList.get(i), temp)){
                    q.add(wordList.remove(i--));
                    ans.add(aannss+1);
                }
            }
        }
        return 0;
    }
    public boolean isonediffer(String a, String b){
        int counter = 0;
        for(int i = 0; i< a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                counter++;
            }
        }
        return counter == 1;
    }
}