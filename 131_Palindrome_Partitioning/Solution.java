import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        backtrack(ans, new LinkedList<>(), s);
        return ans;
    }
    public void backtrack(List<List<String>> list, List<String> currPartition, String s) {
        if(s.length() == 0) {
            list.add(new LinkedList<>(currPartition));
        }else {
            for(int i = 1; i <= s.length(); i++) {
                if(isPalindrome(s.substring(0, i))) {
                    currPartition.add(s.substring(0, i));
                    backtrack(list, currPartition, s.substring(i, s.length()));
                    currPartition.remove(currPartition.size() - 1);
                }
            }
        }
    }
    public boolean isPalindrome(String s) {
        if(s.length() == 0) {
            return true;
        }
        int i = 0, j = s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
