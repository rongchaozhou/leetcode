import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<List<Integer>> helper = new LinkedList<>();
        for(int i = 1; i <= n-k+1; i++){
            helper.add(Arrays.asList(i));
        }
        while(helper.size() > 0){
            List<Integer> temp = helper.removeFirst();
            int nums = temp.size();
            if(nums == k){
                ans.add(temp);
            }else{
                for(int i = temp.get(nums-1) + 1; i <= n-k+nums+1; i++){
                    List<Integer> dummy = new LinkedList<>(temp);
                    dummy.add(i);
                    helper.add(dummy);
                }
            }
        }
        return ans;
    }
}