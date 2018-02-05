import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
       List<List<Integer>> ans = new LinkedList<>();
       if(words == null || words.length < 2) {
           return ans;
       }
       Map<String, Integer> dic = new HashMap<>();
       for(int i = 0; i < words.length; i++) {
           dic.put(words[i], i);
       }
       for(int i = 0; i < words.length; i++) {
           for(int j = 0; j <= words[i].length(); j++) {
               String str1 = words[i].substring(0, j);
               String str2 = words[i].substring(j);
               if(isPalindrome(str1)) {
                   String str2rev = new StringBuilder(str2).reverse().toString();
                   if(dic.containsKey(str2rev) && dic.get(str2rev) != i) {
                       ans.add(Arrays.asList(dic.get(str2rev), i));
                   }
               }
               if(j != words[i].length() && isPalindrome(str2)) {
                   String str1rev = new StringBuilder(str1).reverse().toString();
                   if(dic.containsKey(str1rev) && dic.get(str1rev) != i) {
                       ans.add(Arrays.asList(i, dic.get(str1rev)));
                   }
               }
           }
       }
       return ans;
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
