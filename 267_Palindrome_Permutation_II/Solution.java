import java.util.*;

class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> ans = new LinkedList<>();
        int[] count = new int[256];
        int numOfOdd = 0;
        String center = "";
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        for(int i = 0; i < count.length; i++) {
            if(count[i] % 2 == 1) {
                count[i]--;
                numOfOdd++;
                center = Character.toString((char)i);
            }
        }
        if(numOfOdd <= 1) {
            generate(ans, count, center, s.length());
        }
        return ans;
    }
    public void generate(List<String> ans, int[] count, String build, int len) {
        if(build.length() == len) {
            ans.add(build);
        }else {
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    count[i] -= 2;
                    generate(ans, count, (char) i + build + (char) i, len);
                    count[i] += 2;
                }
            }
        }
    }
}
